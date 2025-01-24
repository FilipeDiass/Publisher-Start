package com.filipediass.publisherstart.dto;

import com.filipediass.publisherstart.model.Publishers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PublishersDTO(

        UUID id,
        String name,
        String email,
        String country,
        BigDecimal revenue,
        LocalDate foundedDate,
        boolean active

) {

    public Publishers toEntity () {
        Publishers publishers = new Publishers();

        publishers.setId(id);
        publishers.setName(name);
        publishers.setEmail(email);
        publishers.setRevenue(revenue);
        publishers.setFoundedDate(foundedDate);
        publishers.setActive(active);

        return publishers;
    }

    public static PublishersDTO toDTO (Publishers publishers) {
        return new PublishersDTO(
                publishers.getId(),
                publishers.getName(),
                publishers.getEmail(),
                publishers.getCountry() != null ? publishers.getCountry().getCode() : null,
                publishers.getRevenue(),
                publishers.getFoundedDate(),
                publishers.isActive()
        );
    }
}
