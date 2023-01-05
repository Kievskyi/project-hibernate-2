package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "store", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Byte id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manager_staff_id")
    Staff staff;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    Address addressId;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
