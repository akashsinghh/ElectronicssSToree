package com.lcea.electronic.store.ElectronicssSTore;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

@EnableWebMvc //inject the mvc spring fox needs this
public class ElectronicssSToreApplication  {
	public static void main(String[] args) {
		SpringApplication.run(ElectronicssSToreApplication.class, args);
	}
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(passwordEncoder.encode("abcd"));
//
//	}
}
