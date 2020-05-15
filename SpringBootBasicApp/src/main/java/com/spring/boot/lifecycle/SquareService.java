package com.spring.boot.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier(value = "SquareService")
public class SquareService implements ShapeService {

    @Autowired
    private Square square;

    @Override
    public void draw() {
        square.createSquare();
    }
}
