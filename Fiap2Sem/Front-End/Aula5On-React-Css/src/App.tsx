import './App.css';  // Importa o CSS global
import Cabecalho from './components/Cabecalho';
import Components1 from './components/Component1';
import Component2 from './components/Component2';

function App() {
    const paragrafo = {
        color: 'green',
        backgroundColor: 'white',
        padding: '15px',
    };

    return (
        <div className="div1">  
            <Cabecalho />
            <p style={{ color: 'blue', backgroundColor: 'black' }}>
                Este é um exemplo de como utilizar CSS no React
            </p>
            <p style={paragrafo}>Segundo parágrafo</p>
            <Components1 />
            <Component2/>
        </div>
    );
}

export default App;
