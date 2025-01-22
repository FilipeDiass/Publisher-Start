package com.filipediass.publisherstart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private GameCategory category;

    private LocalDate launchDate;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publishers publisher;

}
