fn main() {
    let number = 7;

    if number < 5 {
        println!("condition was true");
    } else {
        println!("condition was false");
    }

    let condition = true;
    let number1 = if condition {
        5
    } else {6};

    println!("number1 is {}", number1);

    loop {
        println!("again!");
    }
}
