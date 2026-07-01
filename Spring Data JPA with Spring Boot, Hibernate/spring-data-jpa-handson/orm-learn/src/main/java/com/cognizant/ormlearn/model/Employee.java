package com.cognizant.ormlearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Basic entity created to demonstrate the EmployeeRepository for Hands-on 4
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="emp_id")
    private Integer id;

    @Column(name="emp_name")
    private String name;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}