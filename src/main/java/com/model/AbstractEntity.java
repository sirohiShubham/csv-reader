package com.model;

import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.Column;
import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = -3649285369162252355L;
    @Setter
    @Column(nullable = false, name = "created_timestamp")
    protected DateTime createdTimestamp;

    @Setter
    @Column(nullable = false, name = "last_updated_timestamp")
    protected DateTime lastUpdatedTimestamp;

    @Setter
    @Column(nullable = false, name = "is_active")
    protected Boolean isActive;
}
