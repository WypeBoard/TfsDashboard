package com.wypeboard.model.persistence.domain;

import com.wypeboard.model.persistence.jpa.VersioningJpa;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VERSIONING")
public class Versioning extends VersioningJpa {
}
