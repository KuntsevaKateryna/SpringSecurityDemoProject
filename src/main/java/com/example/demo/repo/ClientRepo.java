package com.example.demo.repo;

import com.example.demo.model.Client;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<Client, Integer> {

    @Query("select * from client where name=:firstName") //it doesn't work without query
    List<Client> findByName(@Param("firstName") String firstName);

    @Modifying
    @Query("UPDATE client SET name = :name WHERE id = :id")
    boolean updateByName(@Param("id") Integer id, @Param("name") String name);


}
