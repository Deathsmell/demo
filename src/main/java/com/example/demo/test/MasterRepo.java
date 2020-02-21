package com.example.demo.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepo extends JpaRepository<Master, Integer> {
    Master findMasterById (Integer id);
}
