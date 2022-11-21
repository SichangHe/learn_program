fn main() {
    {
        let b = Box::new(5);
        println!("b = {}", b);
        assert_eq!(5, *b); // dereference
    }

    {
        use crate::ConsList::{Cons, Nil};
        let list = Cons(1, Box::new(Cons(2, Box::new(Cons(3, Box::new(Nil))))));
        println!("list = {:?}", list);
    }
}

#[derive(Debug)]
enum ConsList {
    Cons(i32, Box<ConsList>),
    Nil,
}
