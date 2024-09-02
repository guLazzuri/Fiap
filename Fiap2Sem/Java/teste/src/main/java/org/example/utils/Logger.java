package org.example.utils;


import org.apache.logging.log4j.LogManager;
import org.example.entities._BaseEntity;

public interface Logger<T extends _BaseEntity> {
    org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);
    void logCreate(T entity);
    void logReadById(T entity);
    void logReadAll(T entity);
    void logUpdateById(T entity);
    void logDeleteById(T entity);

}
