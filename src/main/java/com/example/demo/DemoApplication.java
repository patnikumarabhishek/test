package com.example.demo;

import com.example.demo.entity.Child;
import com.example.demo.entity.Parent;
import com.example.demo.service.ParentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ParentService parentService) {
		return args -> {
			// read json and write to db
			saveParentData(parentService);
			saveChildData(parentService);
		};
	}

	private void saveChildData(ParentService parentService) {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Child>> typeReference = new TypeReference<List<Child>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Child.json");
		try {
			List<Child> users = mapper.readValue(inputStream,typeReference);
			parentService.saveChildData(users);
			System.out.println("Data Saved!");
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
	}

	private void saveParentData(ParentService parentService) {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Parent>> typeReference = new TypeReference<List<Parent>>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Parent.json");
		try {
			List<Parent> users = mapper.readValue(inputStream,typeReference);
			parentService.saveData(users);
			System.out.println("Data Saved!");
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}
	}
}
