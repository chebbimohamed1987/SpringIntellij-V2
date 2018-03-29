package com.example.demo.services;

import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompteServices {

    private final CompteRepository cpr;
    @Autowired
    public CompteServices(CompteRepository cpr) {
        this.cpr = cpr;
    }



public void add (Compte compte){
    cpr.save(compte);

}

public ArrayList getAllComptes(){
    return (ArrayList<Compte>) cpr.findAll();
}


}
