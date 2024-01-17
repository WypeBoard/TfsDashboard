package com.wypeboard.repository;

import com.wypeboard.adapter.database.DbApi;
import com.wypeboard.model.persistence.base.DatabaseEnitity;

import java.util.List;

public abstract class BaseRepositoryImpl<T extends DatabaseEnitity> implements BaseRepository<T> {

    private final DbApi dbApi;

    protected BaseRepositoryImpl(DbApi dbApi) {
        this.dbApi = dbApi;
    }

    @Override
    public T persistEntity(T entity) {
        return dbApi.persistEntity(entity);
    }

    @Override
    public T getEntity(String id) {
        return dbApi.getEntity(getEntityClass(), id);
    }

    @Override
    public List<T> getAllEntities() {
        return dbApi.getAllEntities(getEntityClass());
    }

    @Override
    public void deleteEntity(String id) {
        dbApi.deleteEntity(getEntityClass(), id);
    }

    protected abstract Class<T> getEntityClass();
}
