package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.Client;
import com.example.demo.model.Hobby;
import com.example.demo.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DemoClientServiceImpl implements DemoClientService{



    @Autowired
    private ClientRepo clientRepo;



    @Override
    public void addClient(Integer id, String name, Integer age) {
        Address a1 = new Address(40044, "Sumy", "Geroiv Krut1", 76, 56);
       Set<Hobby> h1 = new HashSet();
       h1.add(new Hobby("dancing1", "zumba trainings"));
       h1.add(new Hobby("reading1", "motivation literatura"));
       h1.add(new Hobby("morning 1routine", "morning exercises, jogging1, contrast washing"));
        clientRepo.save(new Client(null, name, age, a1, h1));
    }

    @Override
    public Client getClient(Integer id) {
        Optional<Client> o1 = clientRepo.findById(id);
        Client c1 = o1.isPresent() ? o1.get() : new Client();
        return c1;
    }

    @Override
    public List<Client> findByName(String name) {
        List<Client> clients =clientRepo.findByName(name);
        return clients;
    }

    @Override
    public boolean updateByName(Integer id, String name) {
        boolean isExist = false;
        Optional<Client> o1 = clientRepo.findById(id);
        if (o1.isPresent()) {
            clientRepo.updateByName(id, name);
            isExist = true;
        }
        return isExist;
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepo.deleteById(id);
    }
}
