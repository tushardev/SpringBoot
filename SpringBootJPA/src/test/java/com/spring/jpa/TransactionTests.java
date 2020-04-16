package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import com.spring.jpa.repository.FlightRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @Before
    public void setup() {
        flightRepository.deleteAll();
    }

    @Test
    public void testRollbackWithoutTransaction() {

        try {
            flightService.saveFlight(new Flights());
        } catch(Exception ex) {
        }
        finally {
           List<Flights> flights = (List) flightRepository.findAll();
            Assert.assertEquals(1, flights.size());
        }
    }


    @Test
    public void testRollbackWithTransaction() {

        try {
            flightService.saveFlightWithTransaction(new Flights());
        } catch(Exception ex) {
        }
        finally {
            List<Flights> flights = (List) flightRepository.findAll();
            Assert.assertEquals(0, flights.size());
        }
    }
}
