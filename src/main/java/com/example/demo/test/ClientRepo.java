package com.example.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ClientRepo extends JpaRepository<Client, Integer> {
}
