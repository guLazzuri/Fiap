// src/components/Cabecalho.tsx

import appleLogo from '../assets/Apple.png'; // Ajuste o caminho conforme necessário
import './Cabecalho.css'; // Alterado para a importação do CSS comum

export default function Cabecalho() {
    return (
        <header className="header">
            <ul>
                <li><button>Logar</button></li>
                <li className='imagem'><img src={appleLogo} alt="Logo"/></li>
                <li><input type="search"/></li>
            </ul>
        </header>
    );
}
