use rand::Rng;
use std::env;

/// generate random number between 0~9 until getting three successive "0"s
/// return the number of numbers generated
fn main() {
    // take a command line argument to decide how many trials
    let args: Vec<String> = env::args().collect();
    let trials: u64 = args[1].parse().unwrap();

    let mut count: u64 = 0; // initialize `count`
    let mut r = rand::thread_rng();

    for _trial in 0..trials {
        'loop1: loop {
            // no "0"
            count += 1;
            if r.gen_range(0..10) == 0 {
                // got a new "0", need two more
                loop {
                    // 'loop2
                    count += 1;
                    if r.gen_range(0..10) == 0 {
                        // got another new "0", need one more
                        // fake 'loop3 {
                        count += 1;
                        if r.gen_range(0..10) == 0 {
                            // got three "0", next trial
                            break 'loop1;
                        } else {
                            // not "0", start from scratch
                            break;
                        }
                    } else {
                        // not "0", start from scratch
                        break;
                    }
                }
            }
        }
    }
    println!(
        "Number generated in average to obtain three successive \"0\": {}",
        ((count as f64) / (trials as f64))
    )
}
