package com.wypeboard.adapter.database;

import com.wypeboard.model.persistence.base.DatabaseEnitity;

import java.util.List;

public interface DbApi {
    <T extends DatabaseEnitity> T persistEntity(T entity);

    <T extends DatabaseEnitity> T getEntity(Class<T> jpa, String id);

    <T extends DatabaseEnitity> List<T> getAllEntities(Class<T> jpa);

    <T extends DatabaseEnitity> void deleteEntity(Class<T> jpa, String id);
}
