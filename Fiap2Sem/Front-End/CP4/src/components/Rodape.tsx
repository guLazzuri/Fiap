// src/components/Cabecalho.tsx
import Logo from '../assets/Apple.png'; // Ajuste o caminho conforme necessário
import './Rodape.css';

export default function Cabecalho() {
    return (
        <footer className='footer'>
            <div>
                <img src={Logo} alt="Logo Apple Lazzuri" />
                <a href="#Cabecalho">Home</a>
                <a href="#Propaganda">Desontos</a>
                <a href="#Aparelhos">Aparelhos</a>
                <a href="#Disp">Dispositivos</a>
            </div>
            <p className='texto-rodape'>
                2024 Apple Lazzuri. Todos os direitos Reservados.
            </p>
        </footer>
    );
}
