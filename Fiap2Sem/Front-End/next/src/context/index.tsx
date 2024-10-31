import React, { createContext } from "react";

export type UserProps = {
    nome: string;
    senha: string;

}

type AuthContextProps = {
    user: UserProps | null;
    login: (user:UserProps)=>void;
    logout: ()=>void;
}
const AuthContext = createContext<AuthContextProps>({} as AuthContextProps
)

const AuthProvider = ({children}: {children:React.ReactNode})=>{
    return(
        <AuthContext>
            {children}
        </AuthContext>
    )

}