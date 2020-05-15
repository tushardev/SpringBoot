package com.mongo.controller;

import com.mongo.domain.FlightInformation;
import com.mongo.service.FlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightInfoService flightInfoService;


    @PostMapping("/flight")
    public void addFlight(@RequestBody FlightInformation flightInfo) {
        flightInfoService.addFlight(flightInfo);
    }

    @PutMapping("/flight")
    public void updateFlight(@RequestBody FlightInformation flightInfo) {
        flightInfoService.updateFlight(flightInfo);
    }

    @DeleteMapping("/flight/{id}")
    public void deleteFlight(@PathVariable String id) {
        flightInfoService.removeFlight(id);
    }

    @GetMapping("/flights")
    public List<FlightInformation> getFlights() {
        return  flightInfoService.findAll();
    }

    @GetMapping("/flights/{departure}")
    public List<FlightInformation> getFlightsByDeparture(@PathVariable String departure) {
        List<FlightInformation> flights = flightInfoService.findByDeparture(departure);
        return  flights;
    }

    @GetMapping("/flightsBy/{aircraft}")
    public List<FlightInformation> getFlightsByAircraft(@PathVariable String aircraft) {
        List<FlightInformation> flights = flightInfoService.findByAircraft(aircraft);
        return  flights;
    }

}
