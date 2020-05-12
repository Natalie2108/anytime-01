package com.example.anytime.controller;

import com.example.anytime.model.Event;
import com.example.anytime.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "https://anytimers.herokuapp.com")
@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping("/event")
    public Event save(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/event")
    public Event update(@RequestBody Event event){ return eventService.save(event); }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/event/{id}")
    public void delete(@PathVariable  int id){eventService.deleteById(id); }

    @GetMapping("/event")
    public Iterable<Event> findAll() { return eventService.findAll(); }

    @GetMapping("/event/{id}")
    public Optional<Event> findById(@PathVariable  int id) {
        return eventService.findById(id);
    }


}

