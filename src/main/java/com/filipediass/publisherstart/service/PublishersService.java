package com.filipediass.publisherstart.service;

import com.filipediass.publisherstart.model.Publishers;
import com.filipediass.publisherstart.repository.PublishersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PublishersService {

    private final PublishersRepository repository;

    public void save (Publishers publishers) {
        repository.save(publishers);
    }

    public Publishers update (Publishers publishers) {
        return repository.save(publishers);
    }

    public Publishers findById (UUID id) {
        return repository.findById(id).orElse(null);
    }

    public boolean delete (Publishers publishers) {
        if (!repository.existsById(publishers.getId())) return false;

        repository.delete(publishers);
        return true;
    }

    public List<Publishers> search (String name, Boolean active) {
        if (name == null && active == null) return repository.findAll();
        if (name == null) return repository.findByActive(active);
        if (active == null) return repository.findByName(name);

        return repository.findByNameAndActive(name, active);
    }
}