use minigrep::*;
use std::{env, process};

fn main() {
    let config = Config::parse_args(env::args()).unwrap_or_else(|err| {
        eprintln!("Error: {}", err);
        process::exit(1);
    });

    let matcher = Matcher::new(&config).unwrap_or_else(|err| {
        eprintln!("Error: {}", err);
        process::exit(1);
    });

    matcher.print_result();
}
