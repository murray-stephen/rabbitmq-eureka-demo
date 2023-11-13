package com.events.userevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserEventsApplication.class, args);
	}

}