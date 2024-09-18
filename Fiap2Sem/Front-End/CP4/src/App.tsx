// src/App.tsx
import Aparelhos from './components/Aparelhos';
import Cabecalho from './components/Cabecalho';
import Propagandas from './components/Propagandas';
import Dispositivos from './components/Disp';
import Rodape from './components/Rodape';




function App() {
  return (
    <>
      <Cabecalho />
      <Propagandas />
      <Aparelhos/>
      <Dispositivos/>
      <Rodape/>
      
    </>
  );
}

export default App;
