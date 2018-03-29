package com.example.demo.repositories;


import com.example.demo.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//checkout home
@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{

}
