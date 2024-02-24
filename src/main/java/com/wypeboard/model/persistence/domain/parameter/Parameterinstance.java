package com.wypeboard.model.persistence.domain.parameter;

import com.wypeboard.model.persistence.jpa.parameter.ParameterinstanceJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETERINSTANCE")
public class Parameterinstance extends ParameterinstanceJpa {
}
