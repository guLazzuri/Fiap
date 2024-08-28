import styled from 'styled-components'
import Button from './Button';

const DivComp1 = styled.div`
    border: 2px solid red;
    padding: 10px ;
    background-color: lightcoral;

    p{
        color: white;
        text-align: justify;
        font-size: 1.5rem

    }

    h2{
        color: white;
        text-align: center;
    };
`


export default function Components1() {
    return (
        <DivComp1>
            <h2>Componente 2</h2>
            <p>Componene 2</p>
            <Button/>
        </DivComp1>
    );
}