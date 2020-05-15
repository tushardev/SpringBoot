package com.mongo;

import com.mongo.domain.Aircraft;
import com.mongo.domain.FlightInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/*
In Spring Boot, a class that implements CommandLineRunner
is executed after the application is bootstrapped
 */

/*@Component
public class ApplicationRunner implements CommandLineRunner {

    private MongoTemplate mongoTemplate;

    public ApplicationRunner(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        FlightInformation domesticFlight = new FlightInformation();
        domesticFlight.setDepartureCity("Pune");
        domesticFlight.setDestinationCity("Bangalore");

        Aircraft aircraft = new Aircraft("INDIGO 370", 200);
        domesticFlight.setAircraft(aircraft);

        this.mongoTemplate.save(domesticFlight);

        System.out.println("Record saved in Mongo DB");
    }
}*/
