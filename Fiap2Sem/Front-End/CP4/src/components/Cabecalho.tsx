// src/components/Cabecalho.tsx

import appleLogo from '../assets/Apple.png'; // Ajuste o caminho conforme necessário
import './Cabecalho.css'; // Alterado para a importação do CSS comum

export default function Cabecalho() {
    return (
        <header className="header">
            <ul>
                <li><img src={appleLogo} alt="Logo" /></li>
                <li><h1>Loja Apple Lazzuri</h1></li>
                <li><button>Logar</button></li>
            </ul>
        </header>
    );
}
