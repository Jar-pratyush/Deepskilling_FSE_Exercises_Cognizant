package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.model.Country;

// This layer contains business logic. It relies on the Repository to fetch data.
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}