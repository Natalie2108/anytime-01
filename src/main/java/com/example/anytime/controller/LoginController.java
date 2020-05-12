package com.example.anytime.controller;

import com.example.anytime.model.Message;
import com.example.anytime.model.Userclazz;
import com.example.anytime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://infinite-shore-94119.herokuapp.com")
@RestController
public class LoginController {

    @Autowired  private UserService userService;
    Userclazz user;

    @GetMapping("/test")
    public List<Userclazz> Login(@RequestBody Userclazz userclazz) {
        return (List<Userclazz>) userService.findByUsernameAndPassword(userclazz.getUsername(), userclazz.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<?> validationMethod(@RequestBody Userclazz userclazz) {
        List<Userclazz> currentUser = Login(userclazz);
        if (currentUser.isEmpty()){
            return new ResponseEntity<Message>(new Message("not valid"), HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<Userclazz>(currentUser.get(0), HttpStatus.OK);
        }
    }



    @GetMapping("/login/{id}")
    public Optional<Userclazz> userById(@PathVariable  int id) {
        return null;
    }



}

