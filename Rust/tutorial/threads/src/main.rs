fn main() {
    let handle = std::thread::spawn(|| {
        for i in 1..10 {
            println!("hi number {} from the spawned thread!", i);
        }
    });

    for i in 1..5 {
        println!("hi number {} from the main thread", i);
    }
    // wait until all the threads finish
    handle.join().unwrap();

    // passing data from main in thread
    let v = vec![1, 2, 3];

    let handle = std::thread::spawn(move || {
        println!("Here's a vector {:?}", v);
    });
    handle.join().unwrap();
}
