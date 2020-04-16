package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import com.spring.jpa.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DerivedQueryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setup() {
        flightRepository.deleteAll();
    }

    @Test
    public void testWithFindBy() {

        Flights flight1 = createFlight("London", null);
        Flights flight2 = createFlight("London", null);
        Flights flight3 = createFlight("New York", null);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flights> flights = flightRepository.findByOrigin("London");
        Assert.assertEquals(2, flights.size());

        Assert.assertEquals("London", flights.get(0).getOrigin());
        Assert.assertEquals("London", flights.get(1).getOrigin());

    }

    @Test
    public void testWithFindByPagingAndSorting() {

        for (int i=0; i<5; i++) {
            flightRepository.save(createFlight("London", String.valueOf(10)));
        }

        flightRepository.save(createFlight("London", "Tushar"));
        flightRepository.save(createFlight("London", "Vedika"));
        flightRepository.save(createFlight("London", "Tushar"));
        flightRepository.save(createFlight("London", "ABC"));
        flightRepository.save(createFlight("London", "PQR"));

        List<Flights> page = (List)flightRepository.findByOrigin("London", PageRequest.of(1, 5, Sort.by("destination")));

        Assert.assertEquals("ABC", page.get(0).getDestination());
        page.stream().forEach(s -> System.out.println(s.getDestination()));

        page = (List)flightRepository.findByOrigin("London", PageRequest.of(1, 5, Sort.by(DESC, "destination")));

        Assert.assertEquals("10", page.get(0).getDestination());
        page.stream().forEach(s -> System.out.println(s.getDestination()));
    }


    private Flights createFlight(String origin, String destination) {
        Flights flight = new Flights();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        return flight;
    }




}
