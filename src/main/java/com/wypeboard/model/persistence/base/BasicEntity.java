package com.wypeboard.model.persistence.base;

import java.time.LocalDateTime;

public interface BasicEntity {

    String getId();

    void setId(String id);

    LocalDateTime getCreated();

    void setCreated(LocalDateTime created);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    LocalDateTime getAltered();

    void setAltered(LocalDateTime altered);

    String getAlteredBy();

    void setAlteredBy(String alteredBy);

}
