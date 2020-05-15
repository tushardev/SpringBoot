package com.mongo.service;

import com.mongo.domain.FlightInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInfoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addFlight(FlightInformation flightInfo) {
        mongoTemplate.insert(flightInfo);
    }

    public void updateFlight(FlightInformation flightInfo) {
        mongoTemplate.save(flightInfo);
    }

    public void removeFlight(String id) {

        Query byId = Query.query(Criteria.where("id").is(id));
        FlightInformation flight = this.mongoTemplate.findOne(byId, FlightInformation.class);

        this.mongoTemplate.remove(flight);
    }

    public List<FlightInformation> findAll() {
            return this.mongoTemplate.findAll(FlightInformation.class,"flights");
    }

    public List<FlightInformation> findByDeparture(String departure) {
        Query byDeparture = new Query()
                .addCriteria(Criteria.where("departure").is(departure));

        return this.mongoTemplate.find(byDeparture, FlightInformation.class);
    }

    public List<FlightInformation> findByAircraft(String aircraft) {
        Query byAircraft = Query.query(Criteria.where("aircraft.model").is(aircraft));

        return this.mongoTemplate.find(byAircraft, FlightInformation.class);
    }

}
