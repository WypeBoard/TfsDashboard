package com.wypeboard.model.persistence.domain;

import com.wypeboard.model.persistence.jpa.VersioningJpa;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "VERSIONING")
public class Versioning extends VersioningJpa {
}
