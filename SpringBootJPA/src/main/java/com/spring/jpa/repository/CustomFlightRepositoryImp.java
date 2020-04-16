package com.spring.jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class CustomFlightRepositoryImp implements  CustomFlightRepository {

    @Autowired
    private EntityManager entityManager;



    @Override
    public void deleteByOrigin(String origin) {

        entityManager.createNativeQuery("Delete from flight where  origin = ?")
                .setParameter(1, "origin")
                .executeUpdate();
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
