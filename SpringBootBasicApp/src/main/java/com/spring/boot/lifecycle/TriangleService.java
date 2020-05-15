package com.spring.boot.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "TriangleService")
public class TriangleService implements ShapeService {

    @Autowired
    private Triangle triangle;

    @Override
    public void draw() {
        triangle.createTraingle();
    }
}
