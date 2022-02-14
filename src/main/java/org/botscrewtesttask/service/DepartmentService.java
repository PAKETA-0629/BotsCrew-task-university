package org.botscrewtesttask.service;

import org.botscrewtesttask.model.Degree;
import org.botscrewtesttask.model.Department;
import org.botscrewtesttask.model.Lector;

import java.util.Map;

public interface DepartmentService {

    Lector findHead(String name);

    Map<Degree, Long> getStatistics(String name);

    Long getAverageSalary(String name);

    Map<Department, Long> countEmployee(String name);
}
