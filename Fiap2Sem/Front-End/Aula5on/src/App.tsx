import Cabecalho from "./components/Cabecalho"
import Componente1 from "./components/Componente1"


function App() {

  let curso: string = 'Javascrpit'   // |  number = 'Javascript'

  const titulo: string = 'titulo'

  const status = 'deployed'

  const aviso = ()=> alert('Esta Mensagem vem de App')

  return (
    <>
    <Cabecalho titulo = {titulo} status = {status}/>
    <Componente1 curso={curso} aviso = {aviso}>
      <h3>Lista de Cursos</h3>
      <ul>
        <li>React</li>
        <li>a</li>
        <li>vue</li>
      </ul>
    </Componente1>
    </>
    
  
  )
}

export default App