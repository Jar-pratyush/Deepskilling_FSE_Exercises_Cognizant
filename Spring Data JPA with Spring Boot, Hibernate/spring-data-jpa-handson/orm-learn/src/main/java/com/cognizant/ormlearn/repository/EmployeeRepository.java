package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Employee;

// Spring Data JPA implementation. Notice how there is zero boilerplate code.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}