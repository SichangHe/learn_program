use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn main() {
    println!("Guess the number!");
    let secret_number = rand::thread_rng().gen_range(1..101);

    'game: loop {
        for _tries in 1..6 {
            // 5 tries
            println!("Please input your guess.");

            let mut guess = String::new(); // declare new mutable String variable `guess`

            io::stdin()
                .read_line(&mut guess)
                .expect("Failed to read line");

            let guess: u32 = match guess.trim().parse() {
                Ok(num) => num,
                Err(_) => continue,
            };
            println!("You guessed: {}", guess);

            match guess.cmp(&secret_number) {
                Ordering::Less => println!("Too small!"),
                Ordering::Greater => println!("Too big!"),
                Ordering::Equal => {
                    println!("You win!");
                    break 'game;
                }
            }
        }
        println!("You lose!\nThe correct answer is {}", secret_number);
        break;
    }
}
