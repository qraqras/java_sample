package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Iterable<Employee> findByNameLike(String name);

}
