package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Table("master")
public class Master {

    @Id
    private Integer id;
    private String name;
    private String specialization;
    private Set<ClientMaster> client_master = new HashSet<ClientMaster>();



    public void addClient(Client client) {

        client_master.add(new ClientMaster(client.getId()));
    }


}
