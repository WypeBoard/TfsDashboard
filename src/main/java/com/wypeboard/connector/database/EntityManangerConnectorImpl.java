package com.wypeboard.connector.database;

import com.wypeboard.model.persistence.base.DatabaseEnitity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EntityManangerConnectorImpl implements EntityManangerConnector {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <T extends DatabaseEnitity> T persistEntity(T jpa) {
        String ident = jpa.getId();
        if (ident == null) {
            jpa.setCreated(LocalDateTime.now());
            jpa.setCreatedBy("SYSTEM");
            jpa.setChanged(LocalDateTime.now());
            jpa.setChangedBy("SYSTEM");
            entityManager.persist(jpa);
        } else {
            jpa = merge(jpa, ident);
        }
        return jpa;
    }

    private <T extends DatabaseEnitity> T merge(T jpa, String ident) {
        Class<? extends T> aClass = Hibernate.getClass(jpa);
        if (getEntity(aClass, ident) != null) {
            jpa.setChanged(LocalDateTime.now());
            jpa.setChangedBy("SYSTEM");
            return entityManager.merge(jpa);
        }
        // Object should exist, but can not be found.
        throw new IllegalArgumentException(String.format("Unable to find %s with id: %s", jpa.getClass().getSimpleName(), ident));
    }


    @Override
    public <T extends DatabaseEnitity> T getEntity(Class<T> jpa, String id) {
        return entityManager.find(jpa, id);
    }

    @Override
    public <T extends DatabaseEnitity> List<T> getAllEntities(Class<T> jpa) {
        return entityManager.createQuery("select e from " + jpa.getSimpleName() + " e").getResultList();
    }

    @Override
    public <T extends DatabaseEnitity> void delete(Class<T> jpa, String id) {
        T entity = getEntity(jpa, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
