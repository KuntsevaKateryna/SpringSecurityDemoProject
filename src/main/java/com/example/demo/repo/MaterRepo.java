package com.example.demo.repo;

import com.example.demo.model.Client;
import com.example.demo.model.Master;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterRepo extends CrudRepository<Master, Integer> {
    @Query("select * from master where name=:firstName")
    List<Master> findByName(@Param("firstName") String firstName);
}
