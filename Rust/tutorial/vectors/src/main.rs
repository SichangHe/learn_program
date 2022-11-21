fn main() {
    let mut v: Vec<i32> = Vec::new(); // empty vector
    let v1 = vec![1, 2, 3]; // vector with initial value

    // update vector
    v.push(5);
    v.push(6);

    // get value
    println!("second element: {}", &v[1]); // crash if invalid index
                                           // alternatively
    match v.get(2) {
        Some(sec) => println!("{}", sec),
        None => println!("nothing"),
    }

    // iterate
    for i in &v {
        println!("{}", i);
    }
}
