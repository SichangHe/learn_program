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

            let guess = Guess::new(guess.trim().parse().expect("Guess a number!"));

            match guess.value.cmp(&secret_number) {
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

pub struct Guess {
    value: i32,
}

impl Guess {
    pub fn new(value: i32) -> Guess {
        if value < 1 || value > 100 {
            panic!("Guess value must be between 1 and 100, got {}.", value);
        }
        Guess { value }
    }

    // getter
    pub fn value(&self) -> i32 {
        self.value
    }
}
