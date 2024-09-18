// src/components/Propagandas.tsx

import './Propagandas.css'; // Importação do CSS comum
import Bf from '../assets/BF.png';
import desconto from '../assets/Desconto.png';
import d50 from '../assets/50-off.png'; // Caminho atualizado para a imagem

export default function Propagandas() {
    return (
        <section className="section">
            

            <div className="ad-container">
                <div className="ad1">
                    <img src={desconto} alt="Desconto 50%" />
                </div>

                <div className='ad2'>
                    <img src= {d50}  alt="Desconto de 50%" />
                </div>

                <div className="ad2">
                    <img className="imag2" src={Bf} alt="Black Friday" />
                </div>
            </div>
        </section>
    );
}
