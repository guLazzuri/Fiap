"use client"
import { AuthContext } from "@/context/page";
import { ChangeEvent, FormEvent, useContext, useState } from "react";
 
 
export default function Home() {
 
  const {user,login, logout} = useContext(AuthContext)
 
  const [dados, setDados] = useState({
    nome:"", senha:""
  })
 
  const handleChange = (e:ChangeEvent<HTMLAnchorElement>)=>{
    const {name, value} = e.target
    setDados({...dados, [name]:value})
  }
 
  const handleSubmit = (e:FormEvent<HTMLFormElement>)=>{
    e.preventDefault()
    login(dados)
  }
 
  return (
   <main className="flex flex-col items-center justify-center p-10">
    <span className="text-2xl mb-2">{user?.nome =="" ? "Fazer o login" : user?.nome}</span>
    {user?.nome =="" ? "" : (<button className="rounded-md bg-red-600 text-white p-2" onClick={logout}>Deslogar</button>)}
 
      <h1 className="mt-4 text-center text-4xl font-bold text-indigo-800">Home</h1>
     
      <form className="w-96 border border-indigo-950 p-6 rounded-md" onSubmit={handleSubmit}>
        <div className="py-2">
          <input className="border-2 border-gray-400 p-2 rounded-md w-full" type="text"placeholder="Nome" name="nome" value={dados.nome}
          onChange={handleChange}/>
        </div>
        <div className="py-2">
          <input className="border-2 border-gray-400 p-2 rounded-md w-full" type="password"placeholder="Senha" name="senha" value={dados.senha}
          onChange={handleChange}/>
        </div>
        <button className="block ms-auto py-2 px-6 bg-indigo-700 rounded-md text-white text-lg font-bold" type="submit">Logar</button>
      </form>
 
   </main>
  );
}
 