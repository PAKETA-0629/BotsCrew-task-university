package org.botscrewtesttask.repository;

import org.botscrewtesttask.model.Degree;
import org.botscrewtesttask.model.Department;
import org.botscrewtesttask.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    List<Department> findAll();

    @Override
    Optional<Department> findById(Long id);

    @Query(value = "SELECT * FROM degree WHERE degree_name=:name", nativeQuery = true)
    Optional<Department> findByName(@Param(value = "name") String name);

    @Query(value = "SELECT final.degree_name, count(final.degree_name) FROM (\n" +
            "    (\n" +
            "        (SELECT department.name, al.lector FROM department JOIN assigned_lector al ON department.id = al.department) AS al\n" +
            "        JOIN lector ON lector.id = al.lector) AS lector\n" +
            "        JOIN degree ON degree.id = lector.id\n" +
            "    ) AS final\n" +
            "WHERE name = :name\n" +
            "GROUP BY degree_name", nativeQuery = true)
    Map<Degree, Long> degreeStatistics(@Param(value = "name") String name);

    @Query(value = "SELECT avg(lector.salary) FROM (\n" +
            "        (SELECT department.name, al.lector FROM department JOIN assigned_lector al ON department.id = al.department) AS al\n" +
            "        JOIN lector ON lector.id = al.lector) AS lector\n" +
            "WHERE name = :name", nativeQuery = true)
    Optional<Long> averageSalary(@Param(value = "name")String name);
    @Query(value = "SELECT al.name, count(al.lector) FROM\n" +
            "    (SELECT department.name, al.lector FROM department JOIN assigned_lector al ON department.id = al.department) AS al\n" +
            "WHERE name = :name\n" +
            "GROUP BY name;", nativeQuery = true)
    Map<Department, Long> countOfEmployee(@Param(value = "name")String name);



}
