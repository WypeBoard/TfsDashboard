package com.wypeboard.model.persistence.jpa;

import com.wypeboard.model.persistence.base.BasicEntity;
import com.wypeboard.model.persistence.converter.LocalDateTimeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class VersioningJpa implements BasicEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false, length = 50)
    private String id;

    @Column(name = "EXECUTED_METHOD")
    private String executedMethod;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATEDBY")
    private String createdBy;

    @Column(name = "CREATED")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime created;

    @Column(name = "ALTEREDBY")
    private String alteredBy;

    @Column(name = "ALTERED")
    private LocalDateTime altered;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getExecutedMethod() {
        return executedMethod;
    }

    public void setExecutedMethod(String executedMethod) {
        this.executedMethod = executedMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String getAlteredBy() {
        return alteredBy;
    }

    @Override
    public void setAlteredBy(String alteredBy) {
        this.alteredBy = alteredBy;
    }

    @Override
    public LocalDateTime getAltered() {
        return altered;
    }

    @Override
    public void setAltered(LocalDateTime altered) {
        this.altered = altered;
    }
}
