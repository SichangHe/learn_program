fn main() {
    let rect1 = Rectangle {
        width: 30,
        height: 50,
    };

    println!("area: {}", rect1.area()); // method syntax

    let rect2 = Rectangle {
        width: 10,
        height: 40,
    };
    let rect3 = Rectangle {
        width: 60,
        height: 45,
    };

    println!("rect1 can hold rect2? {}", rect1.can_hold(&rect2));
    println!("rect1 can hold rect3? {}", rect1.can_hold(&rect3));

    let sq = Rectangle::square(3); // call associated function with `::`
    println!("sq has width: {}", sq.width);
}

#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

// define the *associated function* within the context of `Rectangle`
impl Rectangle {
    // a method for Rectangle
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }

    // constructor
    fn square(size: u32) -> Rectangle {
        Rectangle {
            width: size,
            height: size,
        }
    }
}
