package com.filipediass.publisherstart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
public class Publishers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String email;

    private BigDecimal revenue;

    private LocalDate foundedDate;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries country;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    List<Games> games;

}
