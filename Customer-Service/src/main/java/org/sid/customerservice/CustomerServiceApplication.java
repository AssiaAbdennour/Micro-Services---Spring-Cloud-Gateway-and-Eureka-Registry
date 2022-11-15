package org.sid.customerservice;


import org.sid.customerservice.Entity.Customer;
import org.sid.customerservice.Repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null, "Assia", "assia@gmail.com"));
            customerRepository.save(new Customer(null, "Imane", "imane@gmail.com"));

            customerRepository.save(new Customer(null, "Anas", "Anas@gmail.com"));

            customerRepository.save(new Customer(null, "Anas", "anas@gmail.com"));

            customerRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
