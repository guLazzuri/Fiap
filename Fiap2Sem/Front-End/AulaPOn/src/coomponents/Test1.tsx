import { useState } from "react";

export default function Test1() {
    const [nome, setNome] = useState<string>("Gustavo");

    return (
        <div>
            <h2>teste 1</h2>
            <p>O nome do usuário é: {nome}</p>
            <button onClick={() => setNome("Maria")}>Change Name</button>
        </div>
    );
}
 