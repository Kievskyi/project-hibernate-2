package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.denysdudnik.enums.Feature;
import org.denysdudnik.enums.Rating;
import org.denysdudnik.enums.RatingConverter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Entity
@Table(name = "film", schema = "movie")
@Data
@ToString(exclude = {
        "categories", "actors"
})
@EqualsAndHashCode(exclude = "categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    Short id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    @Type(type = "text")
    String description;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    Set<Category> categories = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    Set<Actor> actors = new HashSet<>();


    @Column(name = "release_year", columnDefinition = "year")
    Integer year;

    @ManyToOne
    @JoinColumn(name = "language_id")
    Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    Language originalLanguage;

    @Column(name = "rental_duration")
    Byte rentalDuration;

    @Column(name = "rental_rate")
    BigDecimal rentalRate;

    @Column(name = "length")
    Short length;

    @Column(name = "replacement_cost")
    BigDecimal replacementCost;

    @Column(name = "rating", columnDefinition = "enum ('G', 'PG', 'PG-13', 'R', 'NC-17') default 'G'")
    @Convert(converter = RatingConverter.class)
    Rating rating;

    @Column(name = "special_features", columnDefinition = "set ('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    String specialFeatures;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;

    public Set<Feature> getSpecialFeatures() {
        if (isNull(specialFeatures) || specialFeatures.isEmpty()) {
            return null;
        }

        Set<Feature> result = new HashSet<>();
        String[] features = specialFeatures.split(",");

        for (String feature : features) {
            result.add(Feature.getFeatureByValue(feature));
        }

        result.remove(null);

        return result;
    }

    public void setSpecialFeatures(Set<Feature> features) {
        if (isNull(features)) {
            specialFeatures = null;
        } else {
            specialFeatures = features.stream().map(Feature::getValue).collect(Collectors.joining(","));
        }
    }
}
