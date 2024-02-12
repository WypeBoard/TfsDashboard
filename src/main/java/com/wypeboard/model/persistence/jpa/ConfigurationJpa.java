package com.wypeboard.model.persistence.jpa;

import com.wypeboard.model.persistence.base.DatabaseEntityImpl;
import com.wypeboard.model.persistence.types.ConfigurationName;
import com.wypeboard.model.persistence.types.ConfigurationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ConfigurationJpa extends DatabaseEntityImpl {

    @Column(name = "TYPE")
    @Enumerated(value = EnumType.STRING)
    private ConfigurationType type;

    @Column(name = "NAME")
    @Enumerated(value = EnumType.STRING)
    private ConfigurationName name;

    @Column(name = "CONFIG_VALUE")
    private String value;

    public ConfigurationType getType() {
        return type;
    }

    public void setType(ConfigurationType type) {
        this.type = type;
    }

    public ConfigurationName getName() {
        return name;
    }

    public void setName(ConfigurationName name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
