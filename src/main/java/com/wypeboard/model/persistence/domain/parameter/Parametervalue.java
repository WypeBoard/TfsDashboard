package com.wypeboard.model.persistence.domain.parameter;

import com.wypeboard.model.persistence.jpa.parameter.ParametervalueJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETERVALUE")
public class Parametervalue extends ParametervalueJpa {
}
