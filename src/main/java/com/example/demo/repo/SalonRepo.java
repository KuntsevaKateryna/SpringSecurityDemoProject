package com.example.demo.repo;

import com.example.demo.model.Salon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo extends CrudRepository<Salon, Integer> {

}
