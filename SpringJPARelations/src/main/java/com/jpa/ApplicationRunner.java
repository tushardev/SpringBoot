package com.jpa;

import com.jpa.entity.CD;
import com.jpa.entity.Musician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) {

        appService.createCD();

        appService.addNewCD();

        appService.createInstitute();

        appService.addCDforMusician();

        CD cd =  appService.getCd(1L);
        System.out.println("<----Musicians for CD ---->" + cd.getTitle());
        cd.getMusicians().forEach(s -> System.out.println(
                s.getFirstName() + " " +
                        s.getMusicInstitute().getInstituteId()));


        Musician musician =  appService.getMusician(2L);
        System.out.println("<----CDs for Musician ---->" + musician.getFirstName());
        musician.getCds().forEach(s -> System.out.println(
                s.getTitle() + " " + s.getGenre()));
    }
}


/**** Add CD along with Musician or only CD. Then map CDs for Musicians. Many to Many relation works.
 Institute to Musician is One to Many bi-directional relation ***/