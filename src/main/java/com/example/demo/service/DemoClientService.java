package com.example.demo.service;

import com.example.demo.model.Client;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DemoClientService {
    public void addClient(Integer id, String name, Integer age);
    public Client getClient(Integer id);
    public List<Client> findByName(String name);
    public boolean updateByName(Integer id, String name);
    public void deleteClient(Integer id);
}
