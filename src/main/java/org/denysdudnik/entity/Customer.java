package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Short id;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    Store storeId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @OneToOne()
    @JoinColumn(name = "address_id")
    Address address;

    @Column(name = "active", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    Boolean active;

    @Column(name = "create_date")
    @CreationTimestamp
    LocalDateTime createDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
