package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

// @SpringBootApplication combines three annotations:
//   @Configuration      - this class can define Spring beans
//   @EnableAutoConfiguration - Spring Boot auto-configures JPA, DataSource etc.
//   @ComponentScan      - Spring scans this package for @Service, @Repository etc.
@SpringBootApplication
public class OrmLearnApplication {

    // Logger lets us print messages at different levels (info, debug, error)
    // instead of using System.out.println()
    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    // We store CountryService here so our test methods can use it
    private static CountryService countryService;

    public static void main(String[] args) {

        // SpringApplication.run() boots the whole application and returns
        // the ApplicationContext (think of it as a box holding all Spring objects)
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        // Retrieve the CountryService bean that Spring created for us
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        // Call our test method
        testGetAllCountries();
    }

    // -------------------------------------------------------------------
    // Test method - calls the service and prints what came back from the DB
    // -------------------------------------------------------------------
    private static void testGetAllCountries() {
        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        // %d{} prints the list in the log
        LOGGER.debug("countries={}", countries);

        LOGGER.info("End");
    }
}
