package com.spring.boot.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SecurityTestController {

    @GetMapping(path = "/books", produces = "application/json")
    public List<String> printBooks() {

        /* Basic Authentication process the request and put user details in Security Context Holder Object */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        /* You can directly get UsernamePasswordAuthenticationToken object from Security Context */
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User user1 = (User) token.getPrincipal();
        System.out.println("The user authentication flag is: "+ token.isAuthenticated());

        System.out.println(user.getUsername());
        user.getAuthorities().stream().forEach(s -> System.out.println(s));

        System.out.println(user1.getUsername());
        user1.getAuthorities().stream().forEach(s -> System.out.println(s));



        List<String> booksList = Arrays.asList("Harry Potter", "Twilight");

        return booksList;
    }








}
