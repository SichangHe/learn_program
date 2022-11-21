fn main() {
    // single producer, single consumer
    let (tx, rx) = std::sync::mpsc::channel();

    std::thread::spawn(move || {
        let val = String::from("hi");
        tx.send(val).unwrap();
    });

    let received = rx.recv().unwrap();
    println!("Got: {}", received);

    // multiple transmits
    let (tx, rx) = std::sync::mpsc::channel();
    std::thread::spawn(move || {
        let vals = vec![
            String::from("hi"),
            String::from("from"),
            String::from("the"),
            String::from("thread"),
        ];

        for val in vals {
            tx.send(val).unwrap();
        }
    });

    println!("rx: {:?}", rx);
    for received in rx {
        println!("Got: {}", received);
    }

    // multiple producer, single consumer
    let (tx, rx) = std::sync::mpsc::channel();

    let tx1 = tx.clone();
    std::thread::spawn(move || {
        let vals = vec![
            String::from("hi"),
            String::from("from"),
            String::from("the"),
            String::from("thread"),
        ];

        for val in vals {
            tx1.send(val).unwrap();
        }
    });

    std::thread::spawn(move || {
        let vals = vec![
            String::from("more"),
            String::from("messages"),
            String::from("for"),
            String::from("you"),
        ];

        for val in vals {
            tx.send(val).unwrap();
        }
    });

    for received in rx {
        println!("Got: {}", received);
    }
}
