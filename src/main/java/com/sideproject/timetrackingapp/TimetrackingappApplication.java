package com.sideproject.timetrackingapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sideproject.timetrackingapp.entity.Role;
import com.sideproject.timetrackingapp.repository.RoleRepository;

@SpringBootApplication
public class TimetrackingappApplication 
{
	/**
	 * main method to start the Time Tracking Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		SpringApplication.run(TimetrackingappApplication.class, args);
	}

	//todo CAPIRE!!!!
	/**
	 * 
	 * @param roleRepo
	 * @return
	 */
	 @Bean
    public CommandLineRunner demo(RoleRepository roleRepo) 
    {
        return (args) -> {
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            roleRepo.save(role);
        };
    }
}
