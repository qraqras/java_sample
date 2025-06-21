package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Iterable<Employee> searchEmployees(String name) {
        return repo.findByNameLike("%" + name + "%");
    }

    public Employee registerEmployee(String name) {
        return repo.save(new Employee(name));
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

}
