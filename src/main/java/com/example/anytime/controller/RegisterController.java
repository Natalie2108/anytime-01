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


@CrossOrigin(origins = "https://anytimers.herokuapp.com")
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;
    private Userclazz userclazz;

    @GetMapping("/test1")
    public List<Userclazz> usernameCheck(@RequestBody Userclazz userclazz) {
        return (List<Userclazz>) userService.findByUsername(userclazz.getUsername());
    }

    @PostMapping("/register")
    //password and username check
    public ResponseEntity<?> notBlank(@RequestBody Userclazz userclazz) {
        if (!usernameCheck(userclazz).isEmpty()){
            return new ResponseEntity<Message>(new Message("username already taken"), HttpStatus.BAD_REQUEST);}
        if (userclazz.getUsername().equals("") || userclazz.getPassword().equals("")) {
            return new ResponseEntity<Message>(new Message("not saved, no valid entries"), HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(userService.save(userclazz), HttpStatus.OK);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/register/{iduser}")
    public void delete(@PathVariable int iduser) {
        userService.deleteById(iduser);
    }

    @GetMapping("/register")
    public List<Userclazz> findAll() {
        return (List<Userclazz>) userService.findAllOrderedById(userclazz);
    }

    @GetMapping("/register/{id}")
    public Optional<Userclazz> userById(@PathVariable  int iduser) {
        return userService.findById(iduser);
    }




}
