package org.example.repositories;

import org.example.entities._BaseEntity;

import java.util.List;

public interface _BaseRepository <T extends _BaseEntity> {
    void add(T object);
    void update(T object);
    void remove(T object);
    T getById(int id);
    List<T> getAll();
}
