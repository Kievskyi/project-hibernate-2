package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "city", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    Short id;

    @Column(name = "city")
    String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
