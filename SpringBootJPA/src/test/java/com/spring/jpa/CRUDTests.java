package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import com.spring.jpa.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CRUDTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testAddFlightWithRepo() {

        List<Flights> flights = null;

        Flights flight = new Flights();
        flight.setOrigin("Pune");
        flight.setDestination("Lonar");

        flightRepository.save(flight);

        flights = (List )flightRepository.findAll();

        flight.setDestination("Mumbai");
        flightRepository.save(flight);

        flights = (List )flightRepository.findAll();

        Assert.assertEquals(1, flights.size());
        Assert.assertEquals("Mumbai", flights.get(0).getDestination());

        flightRepository.deleteAll();

        flights = (List )flightRepository.findAll();
        Assert.assertEquals(0, flights.size());

    }
}
