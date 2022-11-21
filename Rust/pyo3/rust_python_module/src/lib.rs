use pyo3::{pyfunction, pymodule, types::PyModule, wrap_pyfunction, PyResult, Python};

#[pyfunction]
fn sort(vec: Vec<&str>) -> Vec<&str> {
    let mut vec = vec.clone();
    vec.sort_unstable();
    vec
}

#[pymodule]
fn rust_sort(_py: Python, m: &PyModule) -> PyResult<()> {
    m.add_function(wrap_pyfunction!(sort, m)?)?;
    Ok(())
}
