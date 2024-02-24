package com.wypeboard.repository.api;

import com.wypeboard.model.persistence.base.DatabaseEnitity;

import java.util.List;

public interface BaseRepository<T extends DatabaseEnitity> {

    T persistEntity(T entity);

    T getEntity(String id);

    List<T> getAllEntities();

    void deleteEntity(String id);

}
