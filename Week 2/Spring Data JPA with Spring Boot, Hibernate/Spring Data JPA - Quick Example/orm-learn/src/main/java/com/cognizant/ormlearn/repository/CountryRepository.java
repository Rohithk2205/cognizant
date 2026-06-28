package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

// @Repository marks this as a Spring-managed data access component
@Repository
// By extending JpaRepository we get built-in methods like:
//   findAll(), findById(), save(), deleteById() etc.
// The two type parameters are:
//   Country  - the entity this repository manages
//   String   - the type of the primary key (co_code is a String)
public interface CountryRepository extends JpaRepository<Country, String> {
    // No extra code needed here for basic CRUD operations.
    // Spring Data JPA automatically generates the implementation for us.
}
