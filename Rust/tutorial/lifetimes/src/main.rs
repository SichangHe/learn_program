fn main() {
    {
        let result = longest("abcd", "xyz");
        println!("The longest string is {}", result);
    }

    {
        let novel = String::from("Call me Ishmael. Some years ago...");
        let i = ImportantExcerpt {
            part: novel.split('.').next().unwrap(),
        };
        println!("i: {:?}", i);
    }
}

fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

// struct using reference
#[derive(Debug)]
struct ImportantExcerpt<'a> {
    part: &'a str,
}
