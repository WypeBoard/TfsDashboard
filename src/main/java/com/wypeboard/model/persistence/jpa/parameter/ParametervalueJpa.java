package com.wypeboard.model.persistence.jpa.parameter;

import com.wypeboard.model.persistence.base.DatabaseEntityImpl;
import com.wypeboard.model.persistence.domain.parameter.Parameterattribute;
import com.wypeboard.model.persistence.domain.parameter.Parameterinstance;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ParametervalueJpa extends DatabaseEntityImpl {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARAMETERATTRIBUTE_ID", nullable = false)
    private Parameterattribute parameterattribute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARAMETERINSTANCE_ID", nullable = false)
    private Parameterinstance parameterinstance;

    @Column(name = "VALUE", length = 2000)
    private String value;

    public Parameterattribute getParameterattribute() {
        return parameterattribute;
    }

    public void setParameterattribute(Parameterattribute parameterattribute) {
        this.parameterattribute = parameterattribute;
    }

    public Parameterinstance getParameterinstance() {
        return parameterinstance;
    }

    public void setParameterinstance(Parameterinstance parameterinstance) {
        this.parameterinstance = parameterinstance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
