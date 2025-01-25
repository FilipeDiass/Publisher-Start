package com.filipediass.publisherstart.controller;

import com.filipediass.publisherstart.dto.PublishersDTO;
import com.filipediass.publisherstart.model.Countries;
import com.filipediass.publisherstart.model.Publishers;
import com.filipediass.publisherstart.service.CountriesService;
import com.filipediass.publisherstart.service.PublishersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/publishers")
public class PublishersController {

    private final PublishersService publishersService;
    private final CountriesService countriesService;

    @GetMapping("/{id}")
    public ResponseEntity<PublishersDTO> findPublishers (@PathVariable String id) {
        Publishers publishers = publishersService.findById(UUID.fromString(id));
        PublishersDTO publishersDTO = PublishersDTO.toDTO(publishers);

        return ResponseEntity.ok(publishersDTO);
    }

    @PostMapping
    public ResponseEntity<Void> savePublishers (@RequestBody PublishersDTO publishersDTO) {
        Countries countries = null;
        if (publishersDTO.country() != null && !publishersDTO.country().isEmpty()) {
            countries = countriesService.findByCode(publishersDTO.country());
        }

        Publishers publishers = publishersDTO.toEntity();
        publishers.setCountry(countries);

        publishersService.save(publishers);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(publishers.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublishers (@PathVariable String id) {
        Publishers publishers = publishersService.findById(UUID.fromString(id));
        publishersService.delete(publishers);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublishersDTO> updatePublishers (
            @PathVariable String id,
            @RequestBody PublishersDTO publishersDTO) {
        Countries countries = null;
        if (publishersDTO.country() != null && !publishersDTO.country().isEmpty()) {
            countries = countriesService.findByCode(publishersDTO.country());
        }

        Publishers publishers = publishersService.findById(UUID.fromString(id));

        publishers.setName(publishersDTO.name());
        publishers.setEmail(publishersDTO.email());
        publishers.setCountry(countries);
        publishers.setRevenue(publishersDTO.revenue());
        publishers.setFoundedDate(publishersDTO.foundedDate());
        publishers.setActive(publishersDTO.active());

        publishersService.save(publishers);
        PublishersDTO updatedPublishersDTO = PublishersDTO.toDTO(publishers);

        return ResponseEntity.ok(updatedPublishersDTO);
    }

    @GetMapping
    public ResponseEntity<List<PublishersDTO>> searchPublishers (
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean active) {
        List<Publishers> publishers = publishersService.search(name, active);
        List<PublishersDTO> publishersDTOS = publishers.stream().map(PublishersDTO::toDTO).toList();

        return ResponseEntity.ok(publishersDTOS);
    }

}
