package com.example.anytime.service;

import com.example.anytime.model.Userclazz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserService extends CrudRepository<Userclazz, Integer> {

        @Query("SELECT u FROM Userclazz u ORDER BY iduser")
        List<Userclazz> findAllOrderedById(Userclazz userclazz);

        @Query("select u from Userclazz u where u.username = :username and u.password= :password")
        Iterable<Userclazz> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


        @Query("select u from Userclazz u where u.username = :username")
        Iterable<Userclazz> findByUsername(@Param("username") String username);

}
