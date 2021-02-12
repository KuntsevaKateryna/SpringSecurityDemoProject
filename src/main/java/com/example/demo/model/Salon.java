package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table("salon1")
public class Salon {

    @Id
    private Integer id;
    private String name;

    private Set<ClientSalon> client_salon = new HashSet<>();

    public void addClient(Client client) {
        client_salon.add(new ClientSalon(client.getId()));
    }

}
