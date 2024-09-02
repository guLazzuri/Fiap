package org.example.repositories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Artist;
import org.example.entities._BaseEntity;
import org.example.utils.Log4jLogger;

import java.util.List;

public class _BaseRepositoryImpl <T extends _BaseEntity> implements _BaseRepository<T> {

    protected Log4jLogger<T> logger;


    public _BaseRepositoryImpl(Class<T> tClass) {
        this.logger = new Log4jLogger<>(tClass);
    }

    @Override
    public void add(T object) {
        logger.logCreate(object);

    }

    @Override
    public void update(T object) {

    }

    @Override
    public void remove(T object) {

    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        logger.logReadAll(null);
        return null;
    }
}
