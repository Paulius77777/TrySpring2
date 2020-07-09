package com.example.Zenitech;

import com.example.Zenitech.Owner;
import com.example.Zenitech.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner OwnerDemo(OwnerRepository ownerRepository) {
        return (args) -> {

            // create owners
            ownerRepository.save(new Owner("Tomas", "Vilnius"));
            ownerRepository.save(new Owner("Tadas", "Kaunas"));
            ownerRepository.save(new Owner("Linas", "Marijampole"));
            ownerRepository.save(new Owner("Marius", "Kupiskis"));

            // fetch all owners
            System.out.println("Owners found with findAll():");
            System.out.println("---------------------------");
            for (Owner owner : ownerRepository.findAll()) {
                System.out.println(owner.toString());
            }
            System.out.println();

            // fetch owner by id
            Owner owner = ownerRepository.findById(1L).get();
            System.out.println("Owner found with findById(1L):");
            System.out.println("-----------------------------");
            System.out.println(owner.toString());
            System.out.println();

            // fetch owner by ISBN
            Owner ownerWithIBSN = ownerRepository.findByIsbn("Kaunas");
            System.out.println("owner found with findByCity('Kaunas'):");
            System.out.println("------------------------------------------");
            System.out.println(ownerWithIBSN.toString());
            System.out.println();

            // fetch all owner that contain keyword `Tadas`
            System.out.println("Owner that contain keyword 'Tomas':");
            System.out.println("----------------------------------");
            for (Owner b : ownerRepository.findByOwnerContaining("Tadas")) {
                System.out.println(b.toString());
            }
            System.out.println();

            // update owner title
            Owner ownerUpdate = ownerRepository.findById(2L).get();
            ownerUpdate.setOwner("Tomas");
            ownerRepository.save(ownerUpdate);
            System.out.println("Update owner title:");
            System.out.println("------------------");
            System.out.println(ownerUpdate.toString());
            System.out.println();

            // total owner in DB
            System.out.println("Total owner in DB:");
            System.out.println("------------------");
            System.out.println(ownerRepository.count());
            System.out.println();

            // delete all owners
            ownerRepository.deleteAll();
        };
    }
}