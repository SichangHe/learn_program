use rand::Rng;
use std::env;

/// generate random number between 0~9 until getting three successive "0"s
/// return the number of numbers generated
fn main() {
    // take a command line argument to decide how many trials
    let args: Vec<String> = env::args().collect();
    let trials: u64 = args[1].parse().unwrap();

    let mut count: u64 = 0; // initialize `count`
    let mut a;
    let mut b;
    let mut c;
    let mut r = rand::thread_rng();

    for _trial in 0..trials {
        a = 1;
        b = 1;
        c = 1;
        while a != 0 || b != 0 || c != 0 {
            a = b;
            b = c;
            c = r.gen_range(0..10);
            count += 1;
        }
    }
    println!(
        "Number generated in average to obtain three successive \"0\": {}",
        ((count as f64) / (trials as f64))
    )
}
