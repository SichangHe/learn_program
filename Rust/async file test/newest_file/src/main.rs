use tokio::fs;

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let mut latest = std::time::SystemTime::UNIX_EPOCH;
    let mut newest = std::path::PathBuf::new();

    let mut dir = fs::read_dir(".").await?;
    while let Some(entry) = dir.next_entry().await.unwrap() {
        let meta = fs::metadata(&entry.path()).await?;
        let create_time = meta.created().unwrap();
        println!("{:?}", create_time);
        if create_time > latest {
            latest = create_time;
            newest = entry.path();
        }
    }

    println!("{:?}", newest);

    Ok(())
}
