package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "rental", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    Integer id;

    @Column(name = "rental_date", nullable = false)
    LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Column(name = "return_date")
    LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    Staff staffId;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
