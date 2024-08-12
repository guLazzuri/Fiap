package repositorios;

import entidades._EntidadeBase;

import java.util.ArrayList;

public interface _RepositorioBase<T extends _EntidadeBase> {
    // <T> = interfaces genéricas
    // CRUD - create, read, update, delete
    // apenas classes que herdam de entidade base podem ser cadastradas

    void cadastrar(T objeto);
    ArrayList<T> listar();
    void atualizar(T objeto);
    void deletar(T objeto);
    void deletarPorID(T objeto);

    //metodo default
    // nao é o ideal, é muito especifico
    // é uma opcao para implementar metodos dentro da interface, mas gasta muita memoria
    default T buscarPorID(int id){
        return listar().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

}
