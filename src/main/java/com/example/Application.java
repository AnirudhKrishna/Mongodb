package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository test;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	/*	repository.deleteAll();*/

	// save a couple of customers
		test.save(new Customer("Kaustabh", "Kane"));
		test.save(new Customer("Anirudh", "Chaudhary"));
		test.save(new Customer("Anirudh", "krishna"));
		test.save(new Customer("jagjeet", "Singh"));
		test.save(new Customer("Upendra", "Singh"));

		// fetch all customers
				
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : test.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Anirudh'):");
		System.out.println("--------------------------------");
		for (Customer customer : test.findByFirstName("Anirudh")) {
			System.out.println(customer);
		}
		/*System.out.println(repository.findByFirstName("Anirudh"));*/

		System.out.println("Customers found with findByLastName('Singh'):");
		System.out.println("--------------------------------");
		for (Customer customer : test.findByLastName("Singh")) {
			System.out.println(customer);
		}

	}

}