<script>
    import Nested from "./Nested.svelte";
    let name = "world";
    let img = "./stopwar.svg";
    let html_text = "raw html with <em>emphasized words<em/>";

    let count = 0;
    function incrementCount() {
        count += 1;
    }

    // reactive declaration
    $: count_left = 100 - count;
    // can be used in front of a block
    $: {
        console.log("count is " + count);
        console.log("em…");
    }
    $: if (count >= 10) {
        alert("count is greater than 9");
    }

    // reactivity depend on direct assignment
    // A simple rule of thumb: the name of the updated variable must appear on the left hand side of the assignment.
    let numbers = [];
    function addNumThatDoNotReload() {
        numbers.push(numbers.length + 1);
    }
    function addNum() {
        numbers.push(numbers.length + 1);
        numbers = numbers;
    }
    $: sum = numbers.reduce((t, n) => t + n, 0);
</script>

<main>
    <h1>Hello {name}!</h1>

    <img {img} alt="Svelte stopwar icon" />

    <Nested />

    <p>
        {@html html_text}
        <br />
        instead of
        <br />
        {html_text}
    </p>

    <p>
        <button on:click={incrementCount}>+1</button>
        count is now {count}
        <br />
        count left is now {count_left}
    </p>

    <p>
        <button on:click={addNumThatDoNotReload}>this does not reload</button>
        <button on:click={addNum}>this does reload</button>
        {numbers.join(" + ")} = {sum}
    </p>
</main>

<style>
    main {
        text-align: left;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    h1 {
        font-size: 3em;
        font-weight: 100;
    }

    p {
        color: purple;
        font-family: "JetBrains Mono";
        font-size: 0.9em;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }
</style>
