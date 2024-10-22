package Repositorio;

import Entidades._EntidadeBase;

import java.util.List;

public interface RepositorioGenerico <T extends _EntidadeBase> {
    void adicionar (T entidade);
    List<T> listar();
    void atualizar (T entidade);
    void remover (T entidade);
}
