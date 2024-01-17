package com.wypeboard.model.persistence.domain;

import com.wypeboard.model.persistence.jpa.ConfigurationJpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration extends ConfigurationJpa {

}
