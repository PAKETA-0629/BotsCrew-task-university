package org.botscrewtesttask.repository;

import org.botscrewtesttask.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Override
    List<Lector> findAll();

    @Override
    Optional<Lector> findById(Long id);

    //todo
    //List<Lector> searchByTemplate(String template);

}
