import a1 from "../assets/a1.jpg";
import a2 from "../assets/a2.jpg";
import a3 from "../assets/a3.jpg";
import a4 from "../assets/a4.jpg";
import a5 from "../assets/a5.jpg";
import a6 from "../assets/a6.jpg";
import './Disp.css';

// Dados dos dispositivos
const dispositivos = [
    {
        imgSrc: a1,
        nome: "AirPods Pro (2ª geração) com estojo de recarga",
        preco: "R$ 2.100,00",
    },
    {
        imgSrc: a2,
        nome: "AirPods Max - Cinzento sideral",
        preco: "R$ 500,00",
    },
    {
        imgSrc: a3,
        nome: "AirPods (3.ª geração) - Branco ",
        preco: "R$ 1.600,00",
    },
    {
        imgSrc: a4,
        nome: "Capa Capinha Para iPhone Crystal Magnética ",
        preco: "R$ 9.999,00",
    },
    {
        imgSrc: a5,
        nome: "iPad Pencil 2ª Ipad, Iphone | Carregado Por Indução ",
        preco: "R$ 1.530,00",
    },
    {
        imgSrc: a6,
        nome: "Apple AirTag | Rastreador do Apple | Branco",
        preco: "R$ 300,00",
    },
];

export default function Dispositivos() {
    return (
        <section className="dispositivos">
            <div className="cabecalho">
                <h1>Acessórios !!</h1>
            </div>
            
            <div className="galeria">
                {dispositivos.map((dispositivo) => (
                    <div key={dispositivo.nome} className="item">
                        <div className="dispositivo">
                            <img src={dispositivo.imgSrc} alt={dispositivo.nome} />
                            <p className="titulo">{dispositivo.nome}</p>
                            <p className="valor">{dispositivo.preco}</p>
                            <button className="botao">Adicionar ao Carrinho</button>
                        </div>   
                    </div>
                ))}
            </div>
        </section>
    );
}
