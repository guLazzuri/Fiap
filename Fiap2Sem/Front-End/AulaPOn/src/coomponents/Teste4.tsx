import { useState } from "react";
import Filho from "./Filho";

export default function Test4() {
    const [filho, setFilho] = useState<boolean>(false);

    return (
        <div>
            <h2>teste 4</h2>
            {filho ? <Filho /> : null}
            <button onClick={() => setFilho(!filho)}>
                {filho ? 'Excluir comp. filho' : 'Adicionar comp. filho'}
            </button>
        </div>
    );
}
