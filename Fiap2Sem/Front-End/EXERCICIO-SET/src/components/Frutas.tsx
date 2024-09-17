import { useState } from "react";

export default function Frutas() {

    const [frutas , setfrutas] = useState<string[]>(['banana' ,'uva'])
    const [fruta, setFruta] = useState<string>("")
    
    return (
        <div>
            <h2>Frutas</h2>
            <p>Frutas: | {frutas.map((frutass ,index) => <span key={index}> {frutass} | </span>)}</p>
            <input type="text" onChange={(e) => setFruta(e.target.value)} />
            <button onClick={() => setfrutas([...frutas , fruta])}>adcionar</button>
            <button onClick={() => setfrutas([])}>Apagar Lista</button>
        </div>
    );
}
