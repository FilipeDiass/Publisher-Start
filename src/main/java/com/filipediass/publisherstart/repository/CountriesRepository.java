package com.filipediass.publisherstart.repository;

import com.filipediass.publisherstart.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountriesRepository extends JpaRepository<Countries, UUID> {

    Optional<Countries> findByCode (String code);

    List<Countries> findByName (String name);
    
}
