package com.wypeboard.model.persistence.base;

import java.time.LocalDateTime;

public interface DatabaseEnitity {

    void setId(String id);

    String getId();


    void setChanged(LocalDateTime changed);

    LocalDateTime getChanged();


    void setChangedBy(String changedBy);

    String getChangedBy();


    void setCreated(LocalDateTime created);

    LocalDateTime getCreated();


    void setCreatedBy(String createdBy);

    String getCreatedBy();
}
