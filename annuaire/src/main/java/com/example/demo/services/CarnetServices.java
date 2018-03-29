package com.example.demo.services;


import com.example.demo.entities.Carnet;
import com.example.demo.repositories.CarnetRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarnetServices {

    @Autowired
    private  CarnetRespository cr;

    public ArrayList<Carnet> getAllCarnets(){

        return (ArrayList<Carnet>) cr.findAll();
    }

    public Carnet findById (long id){

        return  cr.findById(id).get();


    }

    public void delete (long id){


        cr.deleteById(id);

    }

    public void deletAll (){
        cr.deleteAll();

    }
    public void add (Carnet carnet){
        cr.save(carnet);

    }

    public long taille(){
        return cr.count();
    }

    public void update(Carnet carnet){
        cr.save(carnet);


    }


}
