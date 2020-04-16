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
public class CustomRepoTest {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCustomRepo() {

        Flights flight1 = createFlight("London");
        Flights flight2 = createFlight("Paris");

        flightRepository.save(flight1);
        flightRepository.save(flight2);

        flightRepository.deleteByOrigin("London");

        List<Flights> flights = (List) flightRepository.findAll();

        Assert.assertEquals(1, flights.size());
        Assert.assertEquals("Paris", flights.get(0).getOrigin());

    }

    private Flights createFlight(String origin) {
        Flights flight = new Flights();
        flight.setOrigin(origin);
        return flight;
    }





}
