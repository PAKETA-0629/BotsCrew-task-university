package org.botscrewtesttask.repository;

import org.botscrewtesttask.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Override
    List<Lector> findAll();

    @Override
    Optional<Lector> findById(Long id);

    @Query(value = "SELECT * FROM lector\n" +
            "WHERE first_name ~ :template OR\n" +
            "      last_name ~ :template", nativeQuery = true)
    List<Lector> searchByTemplate(@Param(value = "template") String template);

}
