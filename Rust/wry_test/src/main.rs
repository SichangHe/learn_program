use std::fs::{canonicalize, read_to_string};

use wry::{
    application::{
        event::{Event, WindowEvent},
        event_loop::{ControlFlow, EventLoop},
        window::{Window, WindowBuilder},
    },
    webview::WebViewBuilder,
};

const RETURN_OUTER_HTML: &str = r#"
window.onload = function() {
  let html = document.documentElement.outerHTML;
  window.ipc.postMessage(html);
}
"#;

fn main() -> wry::Result<()> {
    enum UserEvents {
        CloseWindow,
    }

    let event_loop = EventLoop::<UserEvents>::with_user_event();

    let window = WindowBuilder::new()
        .with_title("Render HTML to string")
        .with_visible(false)
        .build(&event_loop)?;

    let html = read_to_string(canonicalize("./MY_HTML_FILE.html")?)?;

    let proxy = event_loop.create_proxy();

    let handler = move |_window: &Window, html: String| {
        println!("{}", &html);

        let _ = proxy.send_event(UserEvents::CloseWindow);
    };

    let _webview = WebViewBuilder::new(window)?
        .with_html(&html)?
        .with_initialization_script(RETURN_OUTER_HTML)
        .with_ipc_handler(handler)
        .build()?;

    event_loop.run(move |event, _, control_flow| {
        *control_flow = ControlFlow::Wait;

        match event {
            Event::WindowEvent {
                event: WindowEvent::CloseRequested,
                ..
            }
            | Event::UserEvent(UserEvents::CloseWindow) => {
                *control_flow = ControlFlow::Exit
            }
            _ => (),
        }
    });
}
