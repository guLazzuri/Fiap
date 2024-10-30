"use client"
 
import { AuthContext } from "@/context/page"
import { redirect } from "next/navigation"
import { useContext } from "react"
 
export default function Compras(){
 
    const {user} = useContext(AuthContext)
 
    if(user?.nome ==""){
        alert ("Para fazer compras, antes faça o login")
        redirect("/")
    }
 
    return(
        <main className="flex flex-col items-center justify-center p-10">
            <h1 className="text-center text-4xl font-bold text-indigo-800">Página de Compras</h1>
 
            <p className="text-3xl font-black">Ola {user?.nome}, faça suas compras!</p>
        </main>
    )
}