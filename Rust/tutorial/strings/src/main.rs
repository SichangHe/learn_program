fn main() {
    // create string
    let mut s = String::new();
    let data = "initial contents".to_string();
    let num = 2.to_string();
    println!("s: {}, data: {}, num: {}", s, data, num);

    // append
    s.push_str("lo"); // push_str a str
    s.push('l'); // push a single character
    println!("s: {}", s);

    // concatenate
    let s1 = String::from("Hello, ");
    let s2 = String::from("world!");
    let s3 = s1 + &s2; // s1 killed, s2 live
    println!("s2: {}, s3: {}", s2, s3);
    // or use format
    let s1 = String::from("tic");
    let s2 = String::from("tac");
    let s3 = String::from("toe");
    let s = format!("{}-{}-{}", s1, s2, s3);
    println!("s1: {}, s2: {}, s3: {}, s: {}", s1, s2, s3, s);
}
