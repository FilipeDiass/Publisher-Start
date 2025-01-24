package com.filipediass.publisherstart.service;

import com.filipediass.publisherstart.model.Countries;
import com.filipediass.publisherstart.repository.CountriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CountriesService {

    private final CountriesRepository repository;

    public void save (Countries countries) {
        repository.save(countries);
    }

    public Countries findByCode (String code) {
        return repository.findByCode(code).orElse(null);
    }

    public List<Countries> findByName (String name) {
        return repository.findByName(name);
    }

    public List<Countries> findAll () {
        return repository.findAll();
    }

}
