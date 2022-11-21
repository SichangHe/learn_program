use std::{
    env::{var, Args},
    error::Error,
    fs,
};

impl Config {
    pub fn parse_args(mut args: Args) -> Result<Config, String> {
        args.next(); // the first argument is the program path
        let query: String; // second argument
        if let Some(s) = args.next() {
            query = s;
        } else {
            return Err(String::from("empty query"));
        };

        let filename: String; //third argument
        if let Some(s) = args.next() {
            filename = s;
        } else {
            return Err(String::from("empty filename"));
        };

        Ok(Config {
            query,
            filename,
            case_sensitive: var("CASE_INSENSITIVE").is_err(),
        })
    }

    pub fn read_file(&self) -> Result<String, Box<dyn Error>> {
        Ok(fs::read_to_string(&self.filename)?)
    }
}

impl Matcher<'_> {
    pub fn new<'a>(config: &'a Config) -> Result<Matcher<'a>, Box<dyn Error>> {
        Ok(Matcher {
            config,
            content: config.read_file()?,
        })
    }

    pub fn print_result(&self) {
        if self.config.case_sensitive {
            self.print_case_sensitive();
        } else {
            self.print_case_insensitive();
        }
    }
    fn print_case_sensitive(&self) {
        for line in self.content.lines() {
            if line.contains(&self.config.query) {
                println!("{}", line);
            }
        }
    }
    fn print_case_insensitive(&self) {
        let query = &self.config.query.to_lowercase();
        for line in self.content.lines() {
            if line.to_lowercase().contains(query) {
                println!("{}", line);
            }
        }
    }
}

pub struct Config {
    pub query: String,
    pub filename: String,
    pub case_sensitive: bool,
}

pub struct Matcher<'a> {
    pub config: &'a Config,
    pub content: String,
}
