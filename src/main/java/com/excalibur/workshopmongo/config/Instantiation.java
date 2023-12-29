package com.excalibur.workshopmongo.config;

import com.excalibur.workshopmongo.domain.User;
import com.excalibur.workshopmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User alexia = new User(null, "Alexia Straza", "alexia@gmail.com");
        User sylnas = new User(null, "Sylnas Storm", "sylnas@gmail.com");
        User yacina = new User(null, "Yacina Crest", "yacina@gmail.com");

        userRepository.saveAll(Arrays.asList(alexia, sylnas, yacina));
    }
}