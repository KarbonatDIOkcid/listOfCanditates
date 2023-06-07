package com.listofcanditates.listOfCanditates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.listofcanditates.listOfCanditates.model")
@EnableJpaRepositories("com.listofcanditates.listOfCanditates.repository")
@ComponentScan("com.listofcanditates.listOfCanditates")
public class ListOfCanditatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListOfCanditatesApplication.class, args);
	}
}
