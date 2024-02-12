package com.wypeboard.model.persistence.jpa;

import com.wypeboard.model.persistence.base.DatabaseEntityImpl;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class VersioningJpa extends DatabaseEntityImpl {

    @Column(name = "EXECUTED_METHOD")
    private String executedMethod;

    @Column(name = "STATUS")
    private String status;


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
}
