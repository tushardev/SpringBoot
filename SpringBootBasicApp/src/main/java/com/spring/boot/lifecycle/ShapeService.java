package com.spring.boot.lifecycle;

public interface ShapeService {
    void draw();
}

/**** This interface is implemented by 2 services. When we auto wire this interface instance as reference
 Spring Container auto wires by Type. But it gets 2 beans of Shape Service type and hence gives error
 There are 2 options to resolve this
 1. Mark any one service as @Primary so that it could be default injected bean for type Shape Service.
 2. Add @Qualifier annotation with name to the bean. same qualifier name can be used to inject the bean when auto wiring.
 **/