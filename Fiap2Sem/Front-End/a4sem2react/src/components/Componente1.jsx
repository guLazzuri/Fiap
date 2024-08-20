import logo_react from "../assets/react.svg"



export default function Componente1(){

    let aluno = 'Gustavo'

    return(
        <>
        <h2>Componente 1</h2>
        <img src={logo_react} alt="Logo react" />
        <br />
        <p>Nome do aluno: {aluno} </p>
        </>  
    )
}