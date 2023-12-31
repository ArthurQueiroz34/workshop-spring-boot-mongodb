package com.excalibur.workshopmongo.config;

import com.excalibur.workshopmongo.domain.Post;
import com.excalibur.workshopmongo.domain.User;
import com.excalibur.workshopmongo.dto.AuthorDTO;
import com.excalibur.workshopmongo.repository.PostRepository;
import com.excalibur.workshopmongo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User alexia = new User(null, "Alexia Straza", "alexia@gmail.com");
        User sylnas = new User(null, "Sylnas Storm", "sylnas@gmail.com");
        User yacina = new User(null, "Yacina Crest", "yacina@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Wise reminder", "Let the fire of your heart burn bright!", new AuthorDTO(alexia));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Never forget!", "Life itself is with you.", new AuthorDTO(alexia));

        userRepository.saveAll(Arrays.asList(alexia, sylnas, yacina));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}