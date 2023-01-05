package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name = "film_text", schema = "movie")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmText {

    @Id
    @Column(name = "film_id")
    Short id;

    @OneToOne
    @JoinColumn(name = "film_id")
    Film film;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", columnDefinition = "text")
    @Type(type = "text")
    String description;
}
