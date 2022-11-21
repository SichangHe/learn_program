use std::collections::HashMap;

fn main() {
    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    // use iterator
    {
        let teams = vec![String::from("Blue"), String::from("Yellow")];
        let initial_scores = vec![10, 50];

        let scores1: HashMap<_, _> = teams.into_iter().zip(initial_scores.into_iter()).collect();
        println!("{:?}", scores1);
    }

    // get value using key
    {
        let blue_score = scores.get("Blue");
        let red_score = scores.get("Red");
        println!("blue score: {:?}, red score: {:?}", blue_score, red_score);
    }

    // iterate
    {
        for (_k, _v) in &scores {
            println!("{}:{}", _k, _v)
        }
    }

    // change value if none
    {
        let blue_score = scores.entry(String::from("Blue")).or_insert(0);
        println!("blue: {}", blue_score);
    }
    {
        let red_score = scores.entry(String::from("Red")).or_insert(0);
        println!("red: {}", red_score);
    }
    println!("scores: {:?}", scores);

    // update value based on old value
    {
        let text = "hello world wonderful world";
        let mut map = HashMap::new();

        for word in text.split_whitespace() {
            let count = map.entry(word).or_insert(0);
            *count += 1; // dereference because `.or_insert` returns a new &mut
        }

        println!("{:?}", map);
    }
}
