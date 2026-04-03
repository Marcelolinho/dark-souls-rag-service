package org.mpp.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class DarkSoulsDataBaseEntity extends PanacheEntityBase {

    @Column(name = "dt_register")
    private Date dtRegister;

    @Column(name = "dt_modification")
    private Date dtModification;

    @PrePersist
    public void prePersist() {
        this.dtRegister = new Date();
        this.dtModification = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.dtModification = new Date();
    }
}
