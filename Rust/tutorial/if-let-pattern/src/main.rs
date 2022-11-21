fn main() {
    let config_max = Some(3u8);
    if let Some(max) = config_max {
        println!("max: {}", max)
    }

    // is the same as
    // match config_max {
    //     Some(max) => println!("max: {}", max),
    //     _ => (),
    // }
}
