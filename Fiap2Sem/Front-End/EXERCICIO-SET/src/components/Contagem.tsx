import { useState } from "react";

export default function Contagem() {
    const [desaparecer, setDesaparecer] = useState<boolean>(false);
    const [count, setCount] = useState<number>(0);

    const aumentar = () => {
        setCount(count + 1);
    };

    const diminuir = () => {
        setCount(count - 1);
    };

    return (
        <div>
            <h2>Contagem</h2>
            <p>O valor da contagem é: {count}</p>
            <button onClick={aumentar}>Change +1</button>
            <button onClick={diminuir}>Change -1</button>
            {desaparecer ? <Contagem /> : ""}
            <button onClick={() => setDesaparecer(!desaparecer)}>
                {desaparecer ? "Desaparecer" : "Aparecer"}
            </button>
        </div>
    );
}
