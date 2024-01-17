package com.wypeboard.repository;

import com.wypeboard.model.persistence.base.DatabaseEnitity;
import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.List;

public interface BaseRepository<T extends DatabaseEnitity> {

    T persistEntity(T entity);

    T getEntity(String id);

    List<T> getAllEntities();

    void deleteEntity(String id);

}
