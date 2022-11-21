fn main() {
    let x = vec![1, 2, 3];
    let equal_to = move |z| z == x; // `x` is consumed

    let y = vec![1, 2, 3];
    let check = equal_to(y);
    println!("{}", check);
}
