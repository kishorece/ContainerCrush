package com.cloudwarriors.containercrush.cloudwarriors.com.cloudwarriors.containercrush.cloudwarriors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cloudwarriors.containercrush.*")
public class CloudwarriorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudwarriorsApplication.class, args);
	}

}
