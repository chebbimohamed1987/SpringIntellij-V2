package com.example.demo.services;


import com.example.demo.entities.Adress;
import com.example.demo.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdressServices {

    @Autowired
    private AdressRepository ar;

    public void add (Adress adress){
        ar.save(adress);

}

    public ArrayList getAllAdresses() {

        return (ArrayList<Adress>) ar.findAll();
    }
}
