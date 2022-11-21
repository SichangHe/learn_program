fn main() {
    let s = String::from("hello world");

    let hello = &s[..5];
    let world = &s[6..11];

    let first_word = first_word(&s);
    let first_word_better = first_word_better(&s);
    println!(
        "hello: {}, world:{}, first word: {}, first word better: {}",
        hello, world, first_word, first_word_better
    );

    let a=[1,2,3,4,5];
    assert_eq!(&a[1..3],&[2,3])
}

fn first_word(s: &String) -> &str {
    let bytes = s.as_bytes(); // convert s to bytes

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[..i];
        }
    }
    &s[..]
}

/// this one can both work on &String an &str
fn first_word_better(s: &str) -> &str {
    let bytes = s.as_bytes(); // convert s to bytes

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[..i];
        }
    }
    &s[..]
}
