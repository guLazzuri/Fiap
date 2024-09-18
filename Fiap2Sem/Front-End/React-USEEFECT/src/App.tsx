
import { useState } from 'react'
import './App.css'
import Contagem from './components/Contagem'

function App() {

  const [ count , setCount] = useState(0)
  const [contagem, seContagem] = useState(true)

  function aumentar(){
    setCount(count +1)
  }

  return (
    <>
      <h1>React - Hook - useEffect</h1>
      <button onClick={() => seContagem(!contagem)}> Criar Contagem</button>
      {contagem ? <Contagem count={count} aumentar={aumentar} />: ''}

    </>
    

  )
}

export default App
