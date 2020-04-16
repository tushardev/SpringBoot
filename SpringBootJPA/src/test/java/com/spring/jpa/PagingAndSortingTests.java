package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import com.spring.jpa.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PagingAndSortingTests {

    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setup() {
        flightRepository.deleteAll();
    }

    @Test
    public void testWithSortBy() {
        Flights flight1 = createFlight("London");
        Flights flight2 = createFlight("Paris");
        Flights flight3 = createFlight("New York");
        Flights flight4 = createFlight("Mumbai");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);

        List<Flights> flights = (List)flightRepository.findAll(Sort.by("origin"));

        Assert.assertEquals("London", flights.get(0).getOrigin());
        Assert.assertEquals("Paris", flights.get(3).getOrigin());

    }

    @Test
    public void testWithPagination() {

        for (int i=0; i<30; i++) {
            flightRepository.save(createFlight(String.valueOf(i)));
        }

        Page<Flights> page = flightRepository.findAll(PageRequest.of(1,5));

        Assert.assertEquals("5", page.getContent().get(0).getOrigin());
        Assert.assertEquals("9", page.getContent().get(4).getOrigin());

        page.stream().forEach(s -> System.out.println(s.getOrigin()));
    }



    private Flights createFlight(String origin) {
        Flights flight = new Flights();
        flight.setOrigin(origin);
        return flight;
    }
}
