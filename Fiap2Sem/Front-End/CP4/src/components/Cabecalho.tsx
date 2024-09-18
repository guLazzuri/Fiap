// src/components/Cabecalho.tsx
import carrinho from '../assets/carrinho.png';
import login from '../assets/login.png';
import appleLogo from '../assets/Apple.png'; // Ajuste o caminho conforme necessário
import './Cabecalho.css'; // Certifique-se de que o caminho está correto

export default function Cabecalho() {
    return (
        <header className="header">
            <div className="left">
                <li className='logo'><img src={appleLogo} alt="Logo" /></li>
            </div>
            <div className="middle">
                <li className='busca'><input type="search" placeholder=" Buscar..." /></li>
            </div>
            <div className="right">
                <li className='login'><img src={login} alt="Login" /></li>
                <li className='carrinho'><img src={carrinho} alt="Carrinho" /></li>
            </div>
        </header>
    );
}
