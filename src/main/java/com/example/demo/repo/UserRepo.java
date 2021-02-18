package com.example.demo.repo;

import com.example.demo.model.Master;
import com.example.demo.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query("select * from user where email=:emailAddress")
    User findByEmail(@Param("emailAddress") String emailAddress);
}
