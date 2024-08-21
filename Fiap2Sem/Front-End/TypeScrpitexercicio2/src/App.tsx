import Cabecalho from "./components/Cabecalho";

function App() {
  const titulo: string = "aula de REACT";
  const codigo: number = 17
  const informacao = () => alert('ESTA  CERTO')
  return (
    <>
      <Cabecalho titulo = {titulo} codigo = {codigo} informacao = {informacao}/>
    </>
  );
}

export default App;
