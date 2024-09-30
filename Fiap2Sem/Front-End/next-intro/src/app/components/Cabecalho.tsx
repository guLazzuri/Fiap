import Link from 'next/link';

export default function Cabecalho() {
    return (
        <nav>
            <Link href={'/'}>Home</Link>
            <span> : </span>
            <Link href={'/produtos'}>Produtos</Link>
            <span> : </span>
            <Link href={'/servicos'}>Serviços</Link>
        </nav>
    );
}
