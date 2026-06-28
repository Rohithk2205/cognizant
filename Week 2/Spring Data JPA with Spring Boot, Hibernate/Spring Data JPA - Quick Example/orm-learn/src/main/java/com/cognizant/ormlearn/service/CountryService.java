package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

// @Service marks this class as a Spring-managed service layer component
@Service
public class CountryService {

    // @Autowired lets Spring automatically inject a CountryRepository object here
    // We don't need to write "new CountryRepository()" - Spring handles it
    @Autowired
    private CountryRepository countryRepository;

    // @Transactional ensures this method runs inside a database transaction.
    // If something goes wrong, the transaction is rolled back automatically.
    @Transactional
    public List<Country> getAllCountries() {
        // findAll() is a built-in JpaRepository method that runs: SELECT * FROM country
        return countryRepository.findAll();
    }
}
