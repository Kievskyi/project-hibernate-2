package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "country", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    Short id;

    @Column(name = "country")
    String country;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
