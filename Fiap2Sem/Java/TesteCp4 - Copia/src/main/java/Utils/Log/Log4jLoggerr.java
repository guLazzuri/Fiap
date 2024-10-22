package Utils.Log;

import AEntidades._EntidadeBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLoggerr<T extends _EntidadeBase> implements Utils.Log.Logger<T> {
    private Logger logger;

    public Log4jLoggerr(Class<T> tClass) {
        this.logger = LogManager.getLogger(tClass);
        logger.info("Iniciando Sistema");
    }

    @Override
    public void logCriar(T entidade) {
        logger.info("Criando: " + entidade);
    }


    @Override
    public void logLerPorId(T entidade) {
        logger.info("Ler por ID: " + entidade);
    }

    @Override
    public void loglertudo(T entidade) {
        logger.info("Ler tudo: " + entidade);
    }

    @Override
    public void LogAtualizar(T entidade) {
        logger.info("Atualizando: " + entidade);
    }

    @Override
    public void logDeletar(T entidade) {
        logger.info("Deletando: " + entidade);
    }
}