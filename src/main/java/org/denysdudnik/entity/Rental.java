package org.denysdudnik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental", schema = "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    Integer id;

    @Column(name = "rental_date", nullable = false)
    LocalDateTime rentalDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "inventory_id")
    Inventory inventoryId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    Customer customerId;

    @Column(name = "return_date")
    LocalDateTime returnDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "staff_id")
    Staff staffId;

    @Column(name = "last_update")
    @UpdateTimestamp
    LocalDateTime lastUpdate;
}
