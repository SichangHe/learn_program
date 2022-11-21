use pyo3::prelude::*;
use rand::Rng;

/// Formats the sum of two numbers as string.
#[pyfunction]
fn trial(trials: usize) -> PyResult<f64> {
    println!("Starting {} trials", trials);

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
    Ok((count as f64) / (trials as f64))
}

/// A Python module implemented in Rust.
#[pymodule]
fn triple0(_py: Python, m: &PyModule) -> PyResult<()> {
    m.add_function(wrap_pyfunction!(trial, m)?)?;
    Ok(())
}
