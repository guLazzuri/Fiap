package Repositorio;

import Entidades._EntidadeBase;
import utils.Log4jLoggerr;

import java.util.ArrayList;
import java.util.List;


public class RepositorioGenericoImp <T extends _EntidadeBase> implements RepositorioGenerico<T> {
    protected List<T> listaDeEntidades = new ArrayList<>();
    protected Log4jLoggerr logger;

    public RepositorioGenericoImp(Class<T> tClass){
        this.logger = new Log4jLoggerr(tClass);
    }

    @Override
    public void adicionar(T entidade) {
        logger.logCriar(entidade);
        listaDeEntidades.add(entidade);
    }

    @Override
    public List<T> listar() {
        logger.loglertudo(null);
        return new ArrayList<>(listaDeEntidades);
    }

    @Override
    public void atualizar(T entidadeAtualizada) {
        for (int i = 0; i < listaDeEntidades.size(); i++){
            T entidade = listaDeEntidades.get(i);
            if (entidade.getId().equals(entidadeAtualizada.getId())){
                listaDeEntidades.set(i, entidadeAtualizada);
                logger.LogAtualizar(entidadeAtualizada);
                return;
            }

        }
    }

    @Override
    public void remover(T entidade) {
        logger.logDeletar(entidade);
        listaDeEntidades.remove(entidade);
    }
}
