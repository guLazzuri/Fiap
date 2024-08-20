type CabProps = {
    status: 'loading' | 'deployed'
}



export default function Cabecalho(props: {titulo: string}&CabProps){

    document.title = props.titulo
    return(
        
        <header>
                <h1>{props.titulo}</h1>
                <p>Status - {props.status}</p>
        </header>
        
    )
}