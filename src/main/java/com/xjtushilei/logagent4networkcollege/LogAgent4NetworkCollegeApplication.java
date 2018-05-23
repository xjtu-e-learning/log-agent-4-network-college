package com.xjtushilei.logagent4networkcollege;

import com.xjtushilei.logagent4networkcollege.entity.Customer;
import com.xjtushilei.logagent4networkcollege.kafka.Producer;
import com.xjtushilei.logagent4networkcollege.kafka.SampleMessage;
import com.xjtushilei.logagent4networkcollege.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LogAgent4NetworkCollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogAgent4NetworkCollegeApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner runner1(Producer producer) {
//		return (args) -> producer.send(new SampleMessage(1, "A simple test message"));
//	}

	@Bean
	public ApplicationRunner runner2(CustomerRepository repository) {
		return (args) -> {
			repository.deleteAll();

			// save a couple of customers
			repository.save(new Customer("Alice", "Smith"));
			repository.save(new Customer("Bob", "Smith"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer);
			}
			System.out.println();

			// fetch an individual customer
			System.out.println("Customer found with findByFirstName('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(repository.findByFirstName("Alice"));

			System.out.println("Customers found with findByLastName('Smith'):");
			System.out.println("--------------------------------");
			for (Customer customer : repository.findByLastName("Smith")) {
				System.out.println(customer);
			}
		};
	}
}
