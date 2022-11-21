fn main() {
    // generic function
    {
        fn largest<T: PartialOrd + Copy>(list: &[T]) -> T {
            let mut largest = list[0];

            for &item in list {
                if item > largest {
                    largest = item;
                }
            }
            largest
        }

        let number_list = vec![34, 50, 25, 100, 65];
        let result = largest(&number_list);
        println!("largest number: {}", result);

        let char_list = vec!['y', 'm', 'a', 'q'];
        let result = largest(&char_list);
        println!("largest char: {}", result);
    }

    // generic struct
    {
        struct Point<T> {
            x: T,
            y: T,
        }

        let integer = Point { x: 5, y: 10 };
        let float = Point { x: 1.0, y: 4.0 };

        // generic method
        impl<T> Point<T> {
            fn x(&self) -> &T {
                &self.x
            }
        }

        println!("p1.x = {}, p2.x = {}", integer.x(), float.x());
    }
}
