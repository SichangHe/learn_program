use rand::Rng;

/// You probably won't win this
fn main() {
    let mut dice_roll: usize;
    let mut num_hat: usize = 3;
    let mut place: usize = 0;
    let mut rng = rand::thread_rng();

    loop {
        dice_roll = rng.gen_range(1..13);
        match dice_roll {
            3 => {
                if num_hat == 7 {
                    println!("You win!");
                    break;
                }
                num_hat += 1;
                println!("Won a fancy hat.");
            }
            7 => {
                if num_hat == 1 {
                    println!("You lose.");
                    break;
                };
                num_hat -= 1;
                println!("Lose a fancy hat.")
            }
            _ => {
                // catch-all pattern
                place += dice_roll;
                println!("{} steps forward.", dice_roll);
                if place > 139 {
                    println!("Over. You lose.");
                    break;
                }
                // or just `()` for nothing
            }
        }
    }
}
