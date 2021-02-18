package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.DemoClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;
import java.util.List;


@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ControllerDemo {

    //inject our Bean as an interface:
    @Autowired
   private DemoClientService clientService;

    @PostMapping("/addClient")
    @PreAuthorize("hasAuthority('write')") // from Permision WRITTING("write");
    public void addNewClient(@RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam Integer age) {
        clientService.addClient(id, name,age);
        log.info("client added");
    }

    @PostMapping("/addClient2")
    @PreAuthorize("hasAuthority('write')") // from Permision WRITTING("write");
    public void addNewClient2(@RequestBody Integer id,
                             @RequestBody String name,
                             @RequestBody Integer age) {
        clientService.addClient(id, name,age);
        log.info("client added throws requestbody params");
    }

    @GetMapping("/getClient")
    @PreAuthorize("hasAuthority('read')") // from Permision READING("read");
    public Client getClient(@RequestParam Integer id) {
        return clientService.getClient(id);
    }

    //second variant od getting client
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public Client getByIdClient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }

    @PostMapping("/updateClient")
    @PreAuthorize("hasAuthority('write')")
    public boolean updateClient(@RequestParam Integer id, @RequestParam String name) {
        return clientService.updateByName(id, name);
    }

    @GetMapping("/findByName")
    @PreAuthorize("hasAuthority('read')")
    public List<Client> findByName(@RequestParam String name) {
        return clientService.findByName(name);
    }

    @DeleteMapping ("/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
