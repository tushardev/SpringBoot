package com.spring.jpa;

import com.spring.jpa.entity.Flights;
import com.spring.jpa.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void saveFlight(Flights flights) {
        flightRepository.save(flights);
        throw new RuntimeException("Falied After Adding Flight");
    }

    @Transactional
    public void saveFlightWithTransaction(Flights flights) {
        flightRepository.save(flights);
        throw new RuntimeException("Falied After Adding Flight");
    }



    public void setFlightRepository(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
}

/**** Method which throws exception after saving the data.
 * It will get tested without and with using transaction.
 */
