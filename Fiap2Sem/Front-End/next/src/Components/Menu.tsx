import Link from 'next/link';

export default function Menu(){
    return (
            <nav className='bg-indigo-600 h-12 flex justify-center'>
                <ul className='flex gap-6 '>
                    <li><Link className = 'font-bold text-white' href={'/'}>Home</Link></li>
                    <li><Link className = 'font-bold text-white' href = {'/compras'}>Compras </Link></li>
                </ul>
            </nav>
    )
}