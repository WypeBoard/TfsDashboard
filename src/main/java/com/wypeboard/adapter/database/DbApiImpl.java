package com.wypeboard.adapter.database;

import com.wypeboard.connector.database.EntityManangerConnector;
import com.wypeboard.model.persistence.base.DatabaseEnitity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class DbApiImpl implements DbApi {

    private final EntityManangerConnector entityManangerConnector;

    public DbApiImpl(EntityManangerConnector entityManangerConnector) {
        this.entityManangerConnector = entityManangerConnector;
    }

    @Override
    public <T extends DatabaseEnitity> T persistEntity(T entity) {
        return entityManangerConnector.persistEntity(entity);
    }

    @Override
    public <T extends DatabaseEnitity> T getEntity(Class<T> jpa, String id) {
        return entityManangerConnector.getEntity(jpa, id);
    }

    @Override
    public <T extends DatabaseEnitity> List<T> getAllEntities(Class<T> jpa) {
        return entityManangerConnector.getAllEntities(jpa);
    }

    @Override
    public <T extends DatabaseEnitity> void deleteEntity(Class<T> jpa, String id) {
        entityManangerConnector.delete(jpa, id);
    }
}
