package com.wypeboard.repository;

import com.wypeboard.model.persistence.domain.Configuration;
import com.wypeboard.model.persistence.types.ConfigurationName;

import java.util.Map;

public interface ConfigurationRepository extends BaseRepository<Configuration> {
    Map<ConfigurationName, String> getAllEntitiesByKeyValue();

    Map<ConfigurationName, Configuration> getAllEntitiesByKeyFunction();
}
