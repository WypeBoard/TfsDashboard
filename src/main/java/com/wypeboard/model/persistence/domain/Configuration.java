package com.wypeboard.model.persistence.domain;

import com.wypeboard.model.persistence.jpa.ConfigurationJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration extends ConfigurationJpa {

}
