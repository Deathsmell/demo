package com.example.demo.test;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mstr")
public class Master {
    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "master", cascade = CascadeType.ALL)
    @CollectionTable(name = "mstr_clients", joinColumns = @JoinColumn(name = "master_id"))
    private List<Client> clients = new ArrayList<>();

    public Master() {

    }

    public Integer getId() {
        return id;
    }

    public Master setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Master setName(String name) {
        this.name = name;
        return this;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Master setClients(List<Client> clients) {
        this.clients = clients;
        return this;
    }
}
