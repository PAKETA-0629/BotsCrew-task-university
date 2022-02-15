package org.botscrewtesttask.service;

import org.botscrewtesttask.model.Lector;

import java.util.List;

public interface DepartmentService {

    Lector findHead(String name);

    List<Object> getStatistics(String name);

    Double getAverageSalary(String name);

    Long countEmployee(String name);
}
