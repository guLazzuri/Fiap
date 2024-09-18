import { useEffect, useState } from "react";

type CountProps = {
    count: number;
    aumentar: () => void;
};

export default function Contagem({ count, aumentar }: CountProps) {
    const [valor, setValor] = useState(0); // Initialize state for 'valor'

    useEffect(() => {
        console.log('Sempre sou chamado');
    }, [count]); 

    useEffect(() => {
        console.log('Sou chamado quando o componente é criado');
    }, []);

    useEffect(() => {
        if(count != 0){
            console.log('Sou chamado quando o componente é alterado');
        }
    }, [count]);

    useEffect(() => {
        return () => {
            console.log('Opss.. Servidor deu erro')
        }
    })
        

    return (
        <div>
            <h2>Contagem</h2>

            <p>valor do Count = {count}</p>
            <p>Valor do valor = {valor}</p>
            <button onClick={aumentar}>Aumentar</button>
            <button onClick={() => setValor(valor + 1)}>Aumentar Valor</button>
        </div>
    );
}
