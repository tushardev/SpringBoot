package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testFlightsAddAndGet() {

        Flights flights = new Flights();
        flights.setOrigin("Pune");
        flights.setDestination("Lonar");

        entityManager.persist(flights);

        List<Flights> flight = entityManager.createQuery("Select f from Flights f", Flights.class).getResultList();

        Assert.assertEquals(1, flight.size());
        Assert.assertEquals("Pune", flight.get(0).getOrigin());
    }
}
