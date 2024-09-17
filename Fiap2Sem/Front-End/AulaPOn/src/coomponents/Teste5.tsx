import { useState } from "react";
type Pet = {nome: string; idade: number}

export default function Test5() {
    const [carros, setCarros] = useState<string[]>(['Onix', 'Pulse', 'Polo']);
    const [carro, setCarro] = useState('');
    //const [pet, setPet] = useState({nome: 'spike', idade: 18})
    //const [pets, setPets] = useState([
        //{nome: 'spike', idade: 18}
        //{nome: 'snake', idade: 8}
        //{nome: 'spk', idade: 3}

    //])

    return (
        <div>
            <h2>teste 5</h2>
            <p>Carros: | {carros.map((car, index) => <span key={index}> {car} | </span>)}</p>
            <input type="text" onChange={(e) => setCarro(e.target.value)} />
            <button onClick={() => setCarros([...carros, carro])}>Adicionar</button>
            <button onClick={() => setCarros([])}>Apagar todos</button>
        </div>
    );
}