use std::{io::stdin, thread};

use wry::{
    application::{
        event::{Event, WindowEvent},
        event_loop::{ControlFlow, EventLoop, EventLoopProxy},
        window::{Window, WindowBuilder},
    },
    webview::WebViewBuilder,
};

const JS_SCRIPT: &str = r#"
window.ipc.postMessage("Hi");
"#;

fn main() -> wry::Result<()> {
    let event_loop = EventLoop::<String>::with_user_event();

    let window = WindowBuilder::new()
        .with_visible(false)
        .build(&event_loop)?;

    let proxy = event_loop.create_proxy();
    thread::spawn(move || {
        logic(proxy);
    });

    let handler = move |_window: &Window, msg: String| {
        println!("Handler received `{}`", &msg);
    };

    let webview = WebViewBuilder::new(window)?
        .with_html("")?
        .with_ipc_handler(handler)
        .build()?;

    event_loop.run(move |event, _, control_flow| {
        *control_flow = ControlFlow::Wait;

        match event {
            Event::UserEvent(script) => {
                if let Err(err) = webview.evaluate_script(&script) {
                    eprintln!("{err} executing script `{script}`.\n");
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

fn logic(proxy: EventLoopProxy<String>) {
    eprintln!("Example: sending {JS_SCRIPT}.");
    if let Err(err) = proxy.send_event(JS_SCRIPT.into()) {
        eprintln!("{err} sending script.\n");
    }
    let stdin = stdin();
    loop {
        let mut buf = String::new();
        if let Err(err) = stdin.read_line(&mut buf) {
            eprintln!("{err} reading stdin.\n")
        };
        if let Err(err) = proxy.send_event(buf) {
            eprintln!("{err} sending script.\n");
        }
    }
}
