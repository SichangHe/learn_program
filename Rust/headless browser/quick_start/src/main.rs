use std::{fs::File, io::Write};

use headless_chrome::{protocol::page::ScreenshotFormat, Browser};

fn browse_baidu() -> Result<(), Box<dyn std::error::Error>> {
    let browser = Browser::default()?;

    let tab = browser.wait_for_initial_tab()?;

    // Navigate to baidu
    tab.navigate_to("https://www.baidu.com")?;

    // get the head
    let ele = tab.wait_for_element("head")?;

    // get content
    let js_function = r#"() => {
    ele = document.getElementsByTagName("html")[0];
    return ele.outerHTML;
}"#;
    let content = ele
        .call_js_fn(js_function, false)?
        .value
        .unwrap()
        .to_string();

    save_html(rem_first_and_last(&content).to_owned(), "baidu.html");

    // Take a screenshot of the entire browser window
    let jpeg_data = tab.capture_screenshot(ScreenshotFormat::JPEG(Some(75)), None, true)?;

    save_pic(jpeg_data, "pic.jpg");

    Ok(())
}

fn rem_first_and_last(value: &str) -> &str {
    let mut chars = value.chars();
    chars.next();
    chars.next_back();
    chars.as_str()
}

fn save_pic(data: Vec<u8>, path: &str) {
    let mut f = File::create(path).unwrap();
    f.write_all(&data).unwrap();
}

fn save_html(data: String, path: &str) {
    let mut f = File::create(path).unwrap();
    f.write_all(data.as_bytes()).unwrap();
}

fn main() {
    if let Err(e) = browse_baidu() {
        eprintln!("{}", e);
    }
}
