package utils;


import Entidades._EntidadeBase;
import org.apache.logging.log4j.LogManager;

public interface Logger<T extends _EntidadeBase> {
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    void logCriar(T entidade);


    void logLerPorId(T entidade);

    void loglertudo(T entidade);
    void LogAtualizar(T entidade);
    void logDeletar(T entidade);

}