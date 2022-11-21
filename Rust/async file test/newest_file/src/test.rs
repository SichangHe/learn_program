use tokio::{fs::File, io::AsyncReadExt};

#[tokio::main]
#[test]
async fn check_same() {
    let mut f = File::open("test/0").await.unwrap();
    let mut b = String::new();
    f.read_to_string(&mut b).await.unwrap();

    assert!(
        b == r#"asdfghjkl;
NGE>BNLGE?>KBNKLEKgo:QL?KGNE>VlenkwO:G>KBN?QN/  n FLgN>KWIqot:OWGN?B LOW;iejGN>B LWoijneO'jgnk>
gN?editingg;"
gNGe"#
    )
}
