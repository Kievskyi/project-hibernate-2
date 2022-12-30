package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.denysdudnik.enums.Rating;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "film", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    Short id;

    @OneToOne
    @JoinColumn(name = "film_id")
    FilmText filmText;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    Set<Actor> actors = new HashSet<>();


    @Column(name = "release_year", columnDefinition = "year")
    Year year;

    @ManyToOne
    @JoinColumn(name = "language_id")
    Language languageId;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    Language originalLanguageId;

    @Column(name = "rental_duration")
    Byte rentalDuration;

    @Column(name = "rental_rate")
    BigDecimal rentalRate;

    @Column(name = "length")
    Short length;

    @Column(name = "replacement_cost")
    BigDecimal replacementCost;

    @Column(name = "rating", columnDefinition = "enum ('G', 'PG', 'PG-13', 'R', 'NC-17') default 'G'")
    @Enumerated(value = EnumType.STRING)
    Rating rating;

    @Column(name = "special_features", columnDefinition = "set ('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
