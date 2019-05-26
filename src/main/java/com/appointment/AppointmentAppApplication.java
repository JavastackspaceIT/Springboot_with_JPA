package com.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.appointment"})
public class AppointmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentAppApplication.class, args);
	}

}

