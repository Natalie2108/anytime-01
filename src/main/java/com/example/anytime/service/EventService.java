package com.example.anytime.service;

import com.example.anytime.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventService extends CrudRepository<Event,Integer> {
}