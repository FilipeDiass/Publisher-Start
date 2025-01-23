package com.filipediass.publisherstart.repository;

import com.filipediass.publisherstart.model.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PublishersRepository extends JpaRepository<Publishers, UUID> {

    List<Publishers> findByNameAndActive (String name, Boolean active);

    List<Publishers> findByName (String name);

    List<Publishers> findByActive (Boolean active);

}
