package com.smart.belt.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String productType;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "condition", nullable = false)
    private String productCondition;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreationTimestamp
    @Column(name = "date", nullable = false)
    private LocalDateTime registerDate;

}
