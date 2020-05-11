package com.example.anytime.controller;

import com.example.anytime.model.Allevent;
import com.example.anytime.service.AlleventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://infinite-shore-94119.herokuapp.com")
@RestController
public class AlleventController {

    @Autowired private AlleventService alleventService;
    private Allevent allevent;

    @PostMapping("/allevent")
    public Allevent create(@RequestBody Allevent allevent) {
        return alleventService.save(allevent);
    }

    @PutMapping("/allevent")
    public Allevent update(@RequestBody Allevent allevent) {
        return alleventService.save(allevent);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("allevent/{idevent}")
    public void delete(@PathVariable int idevent) {
        alleventService.deleteById(idevent);
    }

    @GetMapping("/allevent")
    public List<Allevent> findAll() {
        return (List<Allevent>) alleventService.findAllOrderedByDate(allevent);
    }

    @GetMapping("allevent/{idevent}")
    public Optional<Allevent> eventById(@PathVariable int idevent) {
        return alleventService.findById(idevent);
    }

}
