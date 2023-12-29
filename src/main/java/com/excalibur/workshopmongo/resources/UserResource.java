package com.excalibur.workshopmongo.resources;

import com.excalibur.workshopmongo.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User alexia = new User("1", "Alexia Straza", "alexia@gmail.com");
        User sylnas = new User("2", "Sylnas Storm", "sylnas@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(alexia, sylnas));
        return ResponseEntity.ok().body(list);
    }
}