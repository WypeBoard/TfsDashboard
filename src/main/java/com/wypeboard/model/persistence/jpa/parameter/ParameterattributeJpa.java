package com.wypeboard.model.persistence.jpa.parameter;

import com.wypeboard.model.persistence.base.DatabaseEntityImpl;
import com.wypeboard.model.persistence.domain.parameter.Parametertype;
import com.wypeboard.model.persistence.domain.parameter.Parametervalue;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class ParameterattributeJpa extends DatabaseEntityImpl {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARAMETERTYPE_ID", nullable = false)
    private Parametertype parametertype;

    @Column(name = "NAME", nullable = false, length = 500)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parameterattribute")
    private Set<Parametervalue> parametervalues = new HashSet<>(0);

    public Parametertype getParametertype() {
        return parametertype;
    }

    public void setParametertype(Parametertype parametertype) {
        this.parametertype = parametertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Parametervalue> getParametervalues() {
        return parametervalues;
    }

    public void setParametervalues(Set<Parametervalue> parametervalues) {
        this.parametervalues = parametervalues;
    }
}
