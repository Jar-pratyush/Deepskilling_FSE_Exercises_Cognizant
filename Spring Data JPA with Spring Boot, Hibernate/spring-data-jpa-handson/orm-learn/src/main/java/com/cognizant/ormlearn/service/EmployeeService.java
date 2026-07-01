package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import com.cognizant.ormlearn.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Spring Data JPA handles all the transaction management and session opening/closing automatically.
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}