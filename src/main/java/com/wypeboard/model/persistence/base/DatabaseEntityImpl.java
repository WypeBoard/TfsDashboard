package com.wypeboard.model.persistence.base;

import com.wypeboard.model.persistence.converter.LocalDateTimeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class DatabaseEntityImpl implements DatabaseEnitity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID", unique = true, nullable = false, length = 50)
    private String id;

    /**
     * 'created at' timestamp
     */
    @Column(name="CREATED", nullable=false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime created;

    /**
     * 'created by' field
     */
    @Column(name="CREATED_BY", nullable=false, length=500)
    private String createdBy;

    /**
     * 'updated at' timestamp
     */
    @Column(name="CHANGED", nullable=false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime changed;

    /**
     * 'updated by' field
     */
    @Column(name="CHANGED_BY", nullable=false, length=500)
    private String changedBy;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public LocalDateTime getChanged() {
        return changed;
    }

    @Override
    public void setChanged(LocalDateTime changed) {
        this.changed = changed;
    }

    @Override
    public String getChangedBy() {
        return changedBy;
    }

    @Override
    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }
}
