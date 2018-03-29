package com.example.demo.controllers;

import com.example.demo.entities.Carnet;
import com.example.demo.entities.Civilite;
import com.example.demo.entities.Compte;
import com.example.demo.services.CarnetServices;
import com.example.demo.services.CompteServices;
import com.example.demo.controllers.CarnetController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CompteController {

    @Autowired
    private CompteServices cps;


    @RequestMapping("/AddCompte")

    public ModelAndView ajoutCompte() {


        cps.add(new Compte(1L,115122,"mmohamed", "Lille"));
        cps.add(new Compte(2L,4512,"test", "Paris"));

        cps.add(new Compte(3L,1512124,"test2", "Etranger"));

        return new ModelAndView("pages/Comptes").addObject("liste", cps.getAllComptes());

    }








}
