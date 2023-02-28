package com.lcea.electronic.store.ElectronicssSTore;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ElectronicssSTore.entities")
@EnableJpaRepositories

public class ElectronicssSToreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicssSToreApplication.class, args);
	}

}
