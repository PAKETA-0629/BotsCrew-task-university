package org.botscrewtesttask.repository;

import org.botscrewtesttask.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {

    @Override
    List<Degree> findAll();

    @Override
    Optional<Degree> findById(Long id);

    @Query(value = "SELECT * FROM degree WHERE degree_name=:name", nativeQuery = true)
    Optional<Degree> findByName(@Param(value = "name") String name);
}
