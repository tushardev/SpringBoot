package com.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMongoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoAppApplication.class, args);
	}

	@GetMapping("/")
	public String loadApp() {
		return "Application Started with Mongo DB";
	}

}
