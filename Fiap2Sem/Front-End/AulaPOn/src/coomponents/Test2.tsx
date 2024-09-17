import { useState } from "react";

export default function Test1() {
    const [count, setCount] = useState<number>(0);
    let valorVariavel = 0;

    const aumentar = () => {
        setCount(count + 1);
        valorVariavel = valorVariavel + 1;
    };

    return (
        <div>
            <h2>teste 2</h2>
            <p>O valor do count é: {count}</p>
            <button onClick={aumentar}>Change count</button>
        </div>
    );
}
