package Repositorio;

import AEntidades._EntidadeBase;
import java.util.List;

public interface RepositorioGenerico<T extends _EntidadeBase> {
    void adicionar(T entidade);
    List<T> listar();
    void removerPorId(String id);
    void atualizarPorNome(String nome, T entidade);
}
