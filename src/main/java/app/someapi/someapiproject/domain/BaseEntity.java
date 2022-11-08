package app.someapi.someapiproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Column
    @Id
    @JsonIgnore
    private String id;

    @Column
    @JsonIgnore
    private Date createdAt;

    @Column
    @JsonIgnore
    private Date updatedAt;

    @PrePersist
    private void prePersist() {
        id = UUID.randomUUID().toString();
        createdAt = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = new Date();
    }

}
