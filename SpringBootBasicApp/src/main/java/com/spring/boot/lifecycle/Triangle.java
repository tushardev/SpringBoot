package com.spring.boot.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Triangle {

    @Autowired
    private Point point1;

    @Autowired
    private Point point2;

    @Autowired
    private Point point3;

    private void setCordinates() {
        point1.setCoordinate(12);
        point2.setCoordinate(14);
        point3.setCoordinate(15);
    }

    public void createTraingle() {

        setCordinates();

        System.out.println("Triangle is formed at Co-ordinates :" +
                point1.getCoordinate()+ " " + point2.getCoordinate() + " " + point3.getCoordinate());
    }
}

/***** Here we have created 3 different instances of Point class and assigned to triangle.
 * But the default scope of Point bean is singleton hence it returned the same object with latest value set.
 * Hence the Test returned recent co-ordinate only.
 *
 * When we added Scope as prototype for Point bean - it has created 3 different instances for point.
 *
 * Run the lifecycle with and without scope annotation in Point class to see the scope difference.
 */
