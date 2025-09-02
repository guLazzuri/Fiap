"use client"
import { TipoProduto } from "@/types"
import Link from "next/link"
import { useEffect, useState } from "react"

export default function Produtos(){

    const [lista, setLista] = useState<TipoProduto[]>([])

    useEffect(()=>{
        const chamadaApi = async () => {
            const response = await fetch("http://localhost:3000/api/base-produtos")
            const data = await response.json()
            setLista(data)
            console.log(data);            
        }
        chamadaApi()
    },[])

    return(
        <main className="produtos">
            <h1>Produtos</h1>
            <table>
                <thead>
                    <tr>
                        <th>Id</th><th>Nome</th><th>Preço</th><th>estoque</th><th>Editar</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        lista.map(p=>(
                            <tr key={p.id}>
                                <td>{p.id}</td>
                                <td>{p.nome}</td>
                                <td>{p.preco}</td>
                                <td>{p.estoque}</td>
                                <td><Link href={`/produtos/produto/${p.id}`}>Editar</Link></td>
                            </tr>
                        ))
                    }
                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan={5}>Total de Produtos: {lista.length}</td>
                    </tr>
                </tfoot>
            </table>
        </main>
    )
}

