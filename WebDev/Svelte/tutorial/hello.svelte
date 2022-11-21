<script>
    import Nested from "./Nested.svelte";
    let name = "world";
    let shout = name.toUpperCase();
    let html_text = "raw html with <em>emphasized words<em/>";
    let img = "./stopwar.svg";
</script>

<main>
    <h1>hello {name}</h1>
    <p>shouting: {shout}</p>
    <img {img} alt="Svelt stopwar icon" />
    <Nested />
    <p>
        {@html html_text}
        <br />
        instead of
        <br />
        {html_text}
    </p>
</main>

<style>
    p {
        color: purple;
        font-family: "JetBrains Mono";
        font-size: 0.9em;
    }
</style>
