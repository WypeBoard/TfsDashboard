package com.wypeboard.model.persistence.jpa.parameter;

import com.wypeboard.model.persistence.base.DatabaseEntityImpl;
import com.wypeboard.model.persistence.domain.parameter.Parameterattribute;
import com.wypeboard.model.persistence.domain.parameter.Parameterinstance;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class ParametertypeJpa extends DatabaseEntityImpl {

    @Column(name = "NAME", unique = true, nullable = false, length = 500)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parametertype")
    private Set<Parameterattribute> parameterattributes = new HashSet<Parameterattribute>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parametertype")
    private Set<Parameterinstance> parameterinstances = new HashSet<Parameterinstance>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Parameterattribute> getParameterattributes() {
        return parameterattributes;
    }

    public void setParameterattributes(Set<Parameterattribute> parameterattributes) {
        this.parameterattributes = parameterattributes;
    }

    public Set<Parameterinstance> getParameterinstances() {
        return parameterinstances;
    }

    public void setParameterinstances(Set<Parameterinstance> parameterinstances) {
        this.parameterinstances = parameterinstances;
    }
}
