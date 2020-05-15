package com.spring.boot;

import com.spring.boot.lifecycle.BeanLifeApp;
import com.spring.boot.lifecycle.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication(scanBasePackages = ("com.spring.boot"))
public class App implements CommandLineRunner
{
    private static ConfigurableApplicationContext ctx;

    public static void main( String[] args )
    {
         ctx = SpringApplication.run(App.class,args);
         ctx.close();
    }

    @RequestMapping("/")
    String firstMethod() {
        return "Getting up first Spring boot Application";
    }

    @Autowired()
    @Qualifier("TriangleService")
    private ShapeService shapeService;

    @Autowired
    private BeanLifeApp beanLifeApp;

    @Override
    public void run(String... args) throws Exception {

        shapeService.draw();
        System.out.println("Bean Initialized Name: " + beanLifeApp.getName());
    }

}

/**** Sequence of Program
 1. Spring Application is initialized which triggered bean life cycle methods
 2. Command Line Runner - run method is executed.
 3. We have programmatically closed the application context. But before that @PreDestroy method and then destroy method
    is called.
4. Application is stopped.
 **/