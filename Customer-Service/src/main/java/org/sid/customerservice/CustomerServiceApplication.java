package org.sid.customerservice;


import org.sid.customerservice.Entity.Customer;
import org.sid.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            Stream.of("Assia", "Imane", "Anas", "Yassine").forEach(c -> {
                Customer customer = new Customer();
                customer.setEmail(c.toLowerCase() + "@gmail.com");
                customer.setName(c.toUpperCase());
                customerRepository.save(customer);
            });
        };
    }
}
