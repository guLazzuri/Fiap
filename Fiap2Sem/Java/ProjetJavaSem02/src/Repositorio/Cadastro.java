package Repositorio;

import Entidades._EntidadesBases;

import java.util.ArrayList;

public interface Cadastro <T extends _EntidadesBases>{
    void cadastrar (T objeto);
    ArrayList<T> listar();
    void atualizar(T objeto);
    void deletar(T obejto);


}
