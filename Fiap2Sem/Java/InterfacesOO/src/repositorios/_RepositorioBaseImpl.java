package repositorios;

import entidades._EntidadeBase;

import java.util.ArrayList;

public abstract class _RepositorioBaseImpl<T extends _EntidadeBase> implements _RepositorioBase<T>  {
    ArrayList<T> lista = new ArrayList<>();
    @Override
    public void cadastrar(T objeto) {
        lista.add(objeto);
    }

    @Override
    public ArrayList<T> listar() {
        return lista;
    }

    @Override
    public void atualizar(T objeto) {
        // atualizar objeto por ID
        var objetoAtualizado = lista.stream().filter(x -> x.getId() == objeto.getId()).findFirst().get();
        lista.remove(objetoAtualizado);
        lista.add(objeto);
    }

    @Override
    public void deletar(T objeto) {
        lista.remove(objeto);
    }

    @Override
    public void deletarPorID(T objeto) {
        var objetoAtualizado = lista.stream().filter(x -> x.getId() == objeto.getId()).findFirst().get();
        lista.remove(objetoAtualizado);
    }
}
