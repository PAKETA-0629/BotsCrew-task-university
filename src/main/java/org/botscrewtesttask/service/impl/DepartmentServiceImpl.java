package org.botscrewtesttask.service.impl;

import org.botscrewtesttask.model.Degree;
import org.botscrewtesttask.model.Department;
import org.botscrewtesttask.model.Lector;
import org.botscrewtesttask.repository.DepartmentRepository;
import org.botscrewtesttask.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Lector findHead(String name) {
        Optional<Department> department = departmentRepository.findByName(name);
        if (department.isEmpty()) {
            //todo log and/or exception
            //throw new Exception;
        }
        return department.get().getHeadOfDepartment();
    }

    @Override
    public Map<Degree, Long> getStatistics(String name) {
        return departmentRepository.degreeStatistics(name);
    }

    @Override
    public Long getAverageSalary(String name) {
        Optional<Long> salary = departmentRepository.averageSalary(name);
        if (salary.isEmpty()) {
            //todo log and/or exception
            //throw new Exception;
        }
        return salary.get();
    }

    @Override
    public Map<Department, Long> countEmployee(String name) {
        return departmentRepository.countOfEmployee(name);
    }
}
