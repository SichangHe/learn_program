use std::rc::Rc;

fn main() {
    use crate::List::{Cons, Nil};

    let a = Rc::new(Cons(5, Rc::new(Cons(10, Rc::new(Nil)))));
    let b = Cons(3, Rc::clone(&a));
    let c = Cons(4, Rc::clone(&a));

    println!("b: {:?}", b);
    println!("c: {:?}", c);
}

#[derive(Debug)]
enum List {
    Cons(i32, Rc<List>),
    Nil,
}
