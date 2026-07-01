package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;

// By extending JpaRepository, Spring automatically generates all basic CRUD queries for me in the background!
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}