package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student(
                    "Marian",
                    "marian@gmanil.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student ivan = new Student(
                    "ivan",
                    "ivan@gmanil.com",
                    LocalDate.of(1999, Month.JANUARY, 7)
            );

            repository.saveAll(List.of(mariam, ivan));

        };
    }
}
