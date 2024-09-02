package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities._BaseEntity;

public class Log4jLogger<T extends _BaseEntity> extends _BaseEntity implements org.example.utils.Logger<T> {
    private final Logger logger;

    public Log4jLogger(Class<T> clazz) {
        this.logger = LogManager.getLogger(clazz);
        logger.info("inicializando");
    }

    public void logCreate(T entity) {
        logger.info("Create: " + entity);
    }

    public void logReadById(T entity) {
        logger.info("Read: " + entity);
    }

    public void logReadAll(T entity) {
        logger.info("ReadAll: " + entity);
    }

    public void logUpdateById(T entity) {
        logger.info("Update: " + entity);
    }

    public void logDeleteById(T entity) {
        logger.info("Delete: " + entity);
    }
}