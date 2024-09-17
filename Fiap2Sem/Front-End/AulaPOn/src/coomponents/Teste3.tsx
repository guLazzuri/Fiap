import { useState } from "react";

export default function Test1() {
    const [nome, setNome] = useState<string>("");

    return (
        <div>
            <h2>teste 3</h2>
            <p>O nome do usuário é: {nome}</p>
            <input
                type="text"
                value={nome}
                placeholder="Digite o nome do usuário"
                onChange={(e) => setNome(e.target.value)}
            />
        </div>
    );
}
