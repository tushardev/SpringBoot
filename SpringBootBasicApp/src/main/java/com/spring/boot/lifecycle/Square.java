package com.spring.boot.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Square {

    @Autowired
    private Point point1;

    @Autowired
    private Point point2;

    @Autowired
    private Point point3;

    @Autowired
    private Point point4;

    private void setCordinates() {
        point1.setCoordinate(10);
        point2.setCoordinate(20);
        point3.setCoordinate(30);
        point4.setCoordinate(40);
    }

    public void createSquare() {

        setCordinates();

        System.out.println(" Square is formed at Co-ordinates :" +
                point1.getCoordinate()+ " " + point2.getCoordinate() + " " + point3.getCoordinate()
                + " " + point4.getCoordinate());
    }
}
