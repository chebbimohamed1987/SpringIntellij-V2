package com.example.demo.controllers;


import com.example.demo.entities.Adress;
import com.example.demo.services.AdressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdressController {

    @Autowired
    private AdressServices as;

    @RequestMapping("/AddAdress")

    public ModelAndView ajoutAdress() {
        as.add(new Adress(1L,1 , "Cabanis",  59800,"Lille"));
        as.add( new Adress(2L,1 , "Cabanis",  59800,"Lille"));
        as.add(new Adress(3L,1 , "Cabanis",  59800,"Lille"));
        return new ModelAndView("pages/Adresses").addObject("liste", as.getAllAdresses());

    }

}
