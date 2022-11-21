fn main() {
    let v1 = vec![1, 2, 3];
    {
        let v1_iter = v1.iter();
        for val in v1_iter {
            // v1_iter goes out of scope
            println!("{}", val);
        }
    }

    {
        let mut v1_iter = v1.iter();
        // these are Some(reference)
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
    }

    {
        let mut v1_iter = v1.into_iter(); // v1 goes out of scope
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
        println!("{:?}", v1_iter.next());
    }

    let v1 = vec![1, 2, 3];
    {
        let v1_iter = v1.iter();
        let sum: i32 = v1_iter.sum(); // v1_iter goes out of scope
        println!("{}", sum);
    }

    {
        let v2 = v1.iter().map(|x| x + 1).collect::<Vec<_>>();
        println!("{:?}", v2);
    }

    {
        let shoes = vec![
            Shoe {
                size: 10,
                style: String::from("sneaker"),
            },
            Shoe {
                size: 13,
                style: String::from("sandal"),
            },
            Shoe {
                size: 10,
                style: String::from("boot"),
            },
        ];

        let in_my_size = shoe_in_size(shoes, 10);
        println!("{:?}", in_my_size);
    }

    {
        let counter = Counter::new(3);
        for c in counter {
            println!("{}", c);
        }
    }
}

#[derive(Debug)]
struct Shoe {
    size: u32,
    style: String,
}
fn shoe_in_size(shoes: Vec<Shoe>, size: u32) -> Vec<Shoe> {
    shoes.into_iter().filter(|s| s.size == size).collect()
}

struct Counter {
    count: u32,
}
impl Counter {
    fn new(count: u32) -> Counter {
        Counter { count }
    }
}
impl Iterator for Counter {
    type Item = u32;

    fn next(&mut self) -> Option<Self::Item> {
        if self.count > 1 {
            self.count -= 1;
            Some(self.count)
        } else {
            None
        }
    }
}
