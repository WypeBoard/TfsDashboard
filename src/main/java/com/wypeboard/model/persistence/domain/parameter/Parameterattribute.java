package com.wypeboard.model.persistence.domain.parameter;

import com.wypeboard.model.persistence.jpa.parameter.ParameterattributeJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETERATTRIBUTE")
public class Parameterattribute extends ParameterattributeJpa {
}
