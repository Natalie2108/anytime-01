package com.example.anytime.service;

import com.example.anytime.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserService extends CrudRepository<User, Integer> {

        @Query("select u from User u where u.username = :username and u.password= :password")
        Iterable<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


        @Query("select u from User u where u.username = :username")
        Iterable<User> findByUsername(@Param("username") String username);

}
