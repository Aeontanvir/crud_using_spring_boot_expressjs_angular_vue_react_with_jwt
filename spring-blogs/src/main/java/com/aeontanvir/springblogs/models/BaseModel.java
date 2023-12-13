package com.aeontanvir.springblogs.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseModel implements Serializable {

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdOn;

    @LastModifiedDate
    private Date modifiedOn;

    @LastModifiedBy
    private String lastModifiedBy;
}
