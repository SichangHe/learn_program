fn main() {
    let four = IPAddrKind::V4;
    let six = IPAddrKind::V6;

    let home = IpAddr {
        kind: IPAddrKind::V4,
        address: String::from("127.0.0.1"),
    };
    let loopback = IpAddr {
        kind: IPAddrKind::V6,
        address: String::from("::1"),
    };

    // simpler version
    let home1 = IPAddr::V4(String::from("127.0.0.1"));
    let loopback1 = IPAddr::V6(String::from("::1"));

    let m = Message::Write(String::from("hello"));

    // Option<T>
    let some_number = Some(5);
    let some_string = Some("a string");
    let absent_number: Option<i32> = None;
}

enum IPAddrKind {
    V4,
    V6,
}

struct IpAddr {
    kind: IPAddrKind,
    address: String,
}

// simpler version
enum IPAddr {
    // these are functions of this enum
    V4(String),
    V6(String), // the arguments can be different
}

enum Message {
    Quit,
    Move { x: i32, y: i32 },
    Write(String),
    ChangeColor(i32, i32, i32),
}

impl Message {
    fn call(&self) {}
}
