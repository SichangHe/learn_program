use std::{thread, time::Duration};

fn main() {
    let simulated_user_specified_value = 10;
    let simulated_random_number = 7;

    generate_workout(simulated_user_specified_value, simulated_random_number);
}

fn generate_workout(intensity: i32, random_number: i32) {
    let expensive_closure = |num| {
        println!("calculating slowly...");
        thread::sleep(Duration::from_secs(2));
        num
    };
    if intensity < 25 {
        let mut cacher = Cacher::new(expensive_closure);
        println!("Today, do {} pushups!", cacher.value(intensity));
        println!("Next, do {} situps!", cacher.value(intensity));
    } else {
        if random_number == 3 {
            println!("Take a break today! Remember to stay hydrated!");
        } else {
            println!("Today, run for {} minutes!", expensive_closure(intensity));
        }
    }
}

impl<T> Cacher<T>
where
    T: Fn(i32) -> i32,
{
    fn new(calculation: T) -> Cacher<T> {
        Cacher {
            calculation,
            value: None,
        }
    }

    fn value(&mut self, arg: i32) -> i32 {
        match self.value {
            Some(v) => v,
            None => {
                let v = (self.calculation)(arg);
                self.value = Some(v);
                v
            }
        }
    }
}
struct Cacher<T>
where
    T: Fn(i32) -> i32,
{
    calculation: T,
    value: Option<i32>,
} // private attributes
