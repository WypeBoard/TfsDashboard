package com.wypeboard.repository;

import com.wypeboard.adapter.database.DbApi;
import com.wypeboard.core.exception.JpqlQueryBuilder;
import com.wypeboard.model.logical.Systemparameter;
import com.wypeboard.model.persistence.domain.parameter.Parameterinstance;
import com.wypeboard.model.persistence.domain.parameter.Parametertype;
import com.wypeboard.repository.api.SystemparameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SystemparameterRepositoryImpl implements SystemparameterRepository {

    @Autowired
    public DbApi dbApi;

    public Parameterinstance persistParameterinstance(Systemparameter systemparameter) {
        JpqlQueryBuilder builder = new JpqlQueryBuilder();
        dbApi.getEntityFromJpqlQuery();
    }

    public Parametertype persistParameterType(Systemparameter systemParameter) {

        dbApi.persistEntity()
    }
}
