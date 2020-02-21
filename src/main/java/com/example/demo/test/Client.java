package com.example.demo.test;

import javax.persistence.*;

@Entity
@Table (name ="clnt")
public class Client {

    @Id
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @CollectionTable(name = "mstr_clients", joinColumns = @JoinColumn(name = "clients_id"))
    private Master master;

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public Client setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public Master getMaster() {
        return master;
    }

    public Client setMaster(Master master) {
        this.master = master;
        return this;
    }
}
