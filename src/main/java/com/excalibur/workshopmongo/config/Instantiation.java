package com.excalibur.workshopmongo.config;

import com.excalibur.workshopmongo.domain.Post;
import com.excalibur.workshopmongo.domain.User;
import com.excalibur.workshopmongo.dto.AuthorDTO;
import com.excalibur.workshopmongo.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(alexia, sylnas, yacina));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Wise reminder", "Let the fire of your heart burn bright!", new AuthorDTO(alexia));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Never forget!", "Life itself is with you.", new AuthorDTO(alexia));

        CommentDTO c1 = new CommentDTO("Always let the light beacon", sdf.parse("21/03/2018"), new AuthorDTO(sylnas));
        CommentDTO c2 = new CommentDTO("That's one way to live by", sdf.parse("22/03/2018"), new AuthorDTO(sylnas));
        CommentDTO c3 = new CommentDTO("One must always remember", sdf.parse("23/03/2018"), new AuthorDTO(sylnas));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        alexia.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(alexia);
    }
}