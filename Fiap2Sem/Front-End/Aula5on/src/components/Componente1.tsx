import React from "react";

type Comp1Props = {
    curso: string;
    aviso: ()=> void;
    children : React.ReactNode;

}

export default function Componente1({curso, aviso,children}: Comp1Props){

    return(
        <div>
            <p>Nesta aula vamos aprender um poucco de typescript</p>
            <p>Curso: {curso}</p>
            {children}
            <button onClick={()=> aviso() }>Aviso </button>
        </div>
    )
}