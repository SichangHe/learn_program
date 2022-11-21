fn main() {
    // instance
    // either entirely mutable or entirely not
    let mut user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername123"),
        active: true,
        sign_in_count: 1,
    };

    println!("before change: {}", user1.email);

    // dot notation, change value of specified field
    user1.email = String::from("anotheremail@example.com");
    println!("after change: {}", user1.email);

    let user2 = build_user(String::from("user2@l.com"), String::from("username2"));
    println!("user2's name: {}", user2.username);

    // struct update syntax
    let user3 = User {
        email: String::from("user3@example.com"),
        username: String::from("username3"),
        ..user1
    }; // user1 is still valid because only fields of Copy are used
    let user4 = User {
        email: String::from("user4@example.com"),
        ..user1
    }; // user1's scope ends because field of String (not Copy) is used
       // println!("user1's name: {}", user1.username); // error
    println!(
        "user3's username: {}, user4's username: {}",
        user3.username, user4.username
    );

    let black = Color(0, 0, 0);
    let subject = AlwaysEqual;
}

fn build_user(email: String, username: String) -> User {
    User {
        // field init shorthand
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}
struct User {
    // fields
    // key: value pairs
    active: bool,
    username: String, // let the struct own the value so no need to have life-time
    email: String,
    sign_in_count: u64,
}

// tuple struct
struct Color(i32, i32, i32);

// unit-like struct without field
struct AlwaysEqual;
