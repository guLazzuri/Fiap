import i1 from "../assets/i1.jpg";
import i2 from "../assets/i2.jpg";
import i3 from "../assets/i3.jpg";
import i4 from "../assets/i4.jpg";
import i5 from "../assets/i5.png";
import i6 from "../assets/i6.png";
import './Aparelhos.css';

// Importe outras imagens conforme necessário

const aparelhos = [
    {
        imgSrc: i1,
        nome: "Apple iPhone 15 (128 GB) — Preto",
        preco: "R$ 8.749,00",
    },
    {
        imgSrc: i2,
        nome: "Apple iPhone 15 Plus (128 GB) — Rosa",
        preco: "R$ 6.199,00"
    },
    {
        imgSrc: i3,
        nome: "Apple iPhone 15 Pro (256 GB) — Titânio branco",
        preco: "R$ 9.740,00"
    },
    {
        imgSrc: i4,
        nome: "Apple iPhone 15 Pro Max (512 GB) — Titânio Azul",
        preco: "R$ 9.999,00"
    },
    {
        imgSrc: i5,
        nome: "Apple iPhone 14 (512 GB) — Roxo",
        preco: "R$ 7.530,00"
    },
    {
        imgSrc: i6,
        nome: "Apple iPhone 14 Plus (128 GB) — Meia Noite",
        preco: "R$ 5.499,00"
    }
];
    // Adicione mais aparelhos conforme necessário

export default function Aparelhos() {
    return (
        <>
        <section className="aparelhos">
            <div className="title">
                <h1>Nossos Aparelhos ❤</h1>
            </div>
            
            <div className="vitrine">
                {aparelhos.map(aparelho => (
                    <div className="aa">
                        <div key={aparelho.nome} className="aparelho">
                        <img src={aparelho.imgSrc} alt={aparelho.nome} />
                        <p className="nome">{aparelho.nome}</p>
                        <p className="preco">{aparelho.preco}</p>
                        <button>Adicionar ao Carrinho</button>
                        </div>   
                    </div>
                    
                ))}
            </div>
        </section>
        </>
    );
}
