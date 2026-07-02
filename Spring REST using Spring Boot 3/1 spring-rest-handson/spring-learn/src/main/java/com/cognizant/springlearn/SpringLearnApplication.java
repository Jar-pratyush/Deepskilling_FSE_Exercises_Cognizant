package com.cognizant.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Combining Spring Boot's auto-configuration with a traditional XML context load to demonstrate backwards compatibility and bean retrieval.
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();
    }

    public static void displayCountry() {
        LOGGER.info("Start displayCountry()");

        // 1. Initialize the ApplicationContext using the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // 2. Retrieve the bean using its ID and Class type
        Country country = context.getBean("country", Country.class);

        // 3. Display the details
        LOGGER.debug("Country : {}", country.toString());

        LOGGER.info("End displayCountry()");
    }
}