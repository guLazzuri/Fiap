package Repositorio;

import AEntidades._EntidadeBase;
import Utils.Log.Log4jLoggerr;

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
    public void removerPorId(String id) {
        for (int i = 0; i < listaDeEntidades.size(); i++) {
            T entidade = listaDeEntidades.get(i);
            if (entidade.getId().equals(id)) {
                listaDeEntidades.remove(i);
                logger.logDeletar(entidade);  // Logando a exclusão
                System.out.println("Entidade removida com sucesso: " + entidade);
                return;
            }
        }
        System.out.println("Entidade com o ID " + id + " não encontrada.");
    }

    @Override
    public void atualizarPorNome(String nome, T entidadeAtualizada) {

    }


}
