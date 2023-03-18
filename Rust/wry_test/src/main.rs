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
let html = document.documentElement.outerHTML;
window.ipc.postMessage(html);
"#;

fn main() -> wry::Result<()> {
    let event_loop = EventLoop::<String>::with_user_event();

    let window = WindowBuilder::new()
        .with_visible(false)
        .build(&event_loop)?;

    let html = read_to_string(canonicalize("./MY_HTML_FILE.html")?)?;

    let proxy = event_loop.create_proxy();
    if let Err(err) = proxy.send_event(RETURN_OUTER_HTML.into()) {
        eprintln!("{err} sending script.\n");
    } else {
        eprintln!("Sent script.\n");
    }

    let handler = move |_window: &Window, html: String| {
        println!("{}", &html);
    };

    let webview = WebViewBuilder::new(window)?
        .with_html(&html)?
        .with_ipc_handler(handler)
        .build()?;

    event_loop.run(move |event, _, control_flow| {
        *control_flow = ControlFlow::Wait;

        match event {
            Event::UserEvent(script) => {
                if let Err(err) = webview.evaluate_script(&script) {
                    eprintln!("{err} executing script `{script}`.\n");
                } else {
                    eprintln!("Executed script `{script}`\n");
                }
            }
            Event::WindowEvent {
                event: WindowEvent::CloseRequested,
                ..
            } => *control_flow = ControlFlow::Exit,
            _ => (),
        }
    });
}
