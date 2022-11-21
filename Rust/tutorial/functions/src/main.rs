fn main() {
    println!("Hello, world!");

    another_function(5, 'h');

    expression();

    println!("five(): {}", five());

    println!("The value of 5 + 1 is: {}", plus_one(5));
}

fn another_function(x: i16, unit_label: char) {
    println!("The measurement is: {}{}", x, unit_label);
}

fn expression() {
    let y = {
        let x = 3;
        x + 1
    }; // an expression enclosed by '{}'

    println!("The value of y is: {}", y);
}

fn five() -> i32 {
    5
}

fn plus_one(x: i32) -> i32 {
    x + 1
}
