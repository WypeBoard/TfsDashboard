package com.wypeboard.repository;

import com.wypeboard.adapter.database.DbApi;
import com.wypeboard.model.persistence.domain.Configuration;
import com.wypeboard.model.persistence.jpa.ConfigurationJpa;
import com.wypeboard.model.persistence.types.ConfigurationName;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class ConfigurationRepositoryImpl extends BaseRepositoryImpl<Configuration> implements ConfigurationRepository {

    protected ConfigurationRepositoryImpl(DbApi dbApi) {
        super(dbApi);
    }

    @Override
    protected Class<Configuration> getEntityClass() {
        return Configuration.class;
    }

    @Override
    public Map<ConfigurationName, String> getAllEntitiesByKeyValue() {
        List<Configuration> configurationList = getAllEntities();
        return configurationList.stream().collect(Collectors.toMap(ConfigurationJpa::getName, ConfigurationJpa::getValue));
    }

    @Override
    public Map<ConfigurationName, Configuration> getAllEntitiesByKeyFunction() {
        List<Configuration> configurationList = getAllEntities();
        return configurationList.stream().collect(Collectors.toMap(ConfigurationJpa::getName, Function.identity()));
    }
}
