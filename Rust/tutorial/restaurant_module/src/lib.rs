pub fn eat_at_restaurant() {
    crate::front_of_house::hosting::add_to_waitlist(); // with `crate`: absolute path; without: relative path
                                                       // `super` stands for parent module in relative path
}
mod front_of_house {
    pub mod hosting {
        pub fn add_to_waitlist() {}
        fn seat_at_table() {}
    }
    mod serving {
        fn take_over() {}
        fn serve_order() {}
        fn take_payment() {}
    }
}

/* another way to shorten path*/
use crate::front_of_house::hosting;
pub fn take_away() {
    hosting::add_to_waitlist();
}
