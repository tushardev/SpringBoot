package com.spring.jpa.repository;

import com.spring.jpa.entity.Flights;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface FlightRepository extends PagingAndSortingRepository<Flights, Long>, CustomFlightRepository {

    public List<Flights> findByOrigin(String origin);

    public List<Flights> findByOrigin(String origin, Pageable pageRequest);
}
