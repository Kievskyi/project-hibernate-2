package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "address", schema = "movie",
        indexes = {
                @Index(name = "idx_fk_city_id", columnList = "city_id")
        })
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    Short id;

    @Column(name = "address", length = 50, nullable = false)
    String address;

    @Column(name = "address2", length = 50)
    String address2;

    @Column(name = "district", length = 20, nullable = false)
    String district;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    City city;

    @Column(name = "postal_code", length = 10)
    String postalCode;

    @Column(name = "phone", length = 20, nullable = false)
    String phone;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}