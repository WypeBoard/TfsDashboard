package com.wypeboard.model.persistence.domain.parameter;

import com.wypeboard.model.persistence.jpa.parameter.ParametertypeJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARAMETERTYPE")
public class Parametertype extends ParametertypeJpa {
}
