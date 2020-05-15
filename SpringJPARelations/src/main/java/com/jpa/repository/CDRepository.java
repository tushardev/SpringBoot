package com.jpa.repository;

import com.jpa.entity.CD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CDRepository extends JpaRepository<CD, Long> {
}
