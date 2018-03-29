package com.example.demo.repositories;

import com.example.demo.entities.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarnetRespository extends JpaRepository<Carnet , Long > {

}
