fn main() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };

    println!("rect1 is {:?}", rect1);
    println!("rect1 is {:#?}", rect1); // print it in multiple lines nicely

    dbg!(&rect1); // quick and dirty debug

    println!(
        "The area of the rectangle is {} square pixels.",
        area(&rect1)
    );
}

fn area(rectangle: &Rectangle) -> u32 {
    rectangle.width * rectangle.height
}

#[derive(Debug)] // this is so that it can be printed
struct Rectangle {
    width: u32,
    height: u32,
}
