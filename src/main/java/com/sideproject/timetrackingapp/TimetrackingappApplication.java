package com.sideproject.timetrackingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // TODO: remove once database is set 
public class TimetrackingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetrackingappApplication.class, args);
	}

}
