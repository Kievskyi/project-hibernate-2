package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    Byte id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    Address addressId;

    @Column(name = "picture", columnDefinition = "blob")
    @Lob
    byte[] picture;

    @Column(name = "email", length = 50)
    String email;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "store_id")
    Store storeId;

    @Column(name = "active")
    Boolean active;

    @Column(name = "username", length = 16, nullable = false)
    String username;

    @Column(name = "password", length = 40)
    String password;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
