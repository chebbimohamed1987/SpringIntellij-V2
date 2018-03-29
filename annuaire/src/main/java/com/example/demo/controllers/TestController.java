package com.example.demo.controllers;

import com.example.demo.entities.Carnet;
import com.example.demo.entities.Civilite;
import com.example.demo.entities.Compte;
import com.example.demo.services.CarnetServices;
import com.example.demo.services.CompteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @Autowired
    private CompteServices cps;

    @Autowired
    private CarnetServices cs;

    @RequestMapping("/CreationTest")
    public ModelAndView ajoutComptesEtContact() {





        Compte compte1 = new Compte(1L,115112,"testun", "Lille");
        Compte compte2 = new Compte(2L,4512,"testdeux", "Paris");
        Compte compte3 = new Compte(3L,1512124,"testtrois", "Etranger");

        Carnet contact1 =new Carnet(1L, Civilite.M, "Besson", "testun", "1959-10-18", "+33618555723", "mohamed.chebbi@viacesi.fr", "75015", "Paris");
        Carnet contact2 =new Carnet(2L, Civilite.MME, "Ullmann", "testdeux", "1938-12-16", "+3361850423", "chebbimohamed1987@live.fr", "59800", "Tokyo");
        Carnet contact3 =new Carnet(3L, Civilite.M, "Lynch", "testtrois", "1946-01-20", "+3361850423", "chebbimohamed1987@gmail.com", "59801", "Missoula");

        (new Compte(4L,115122,"alpha", "Lille")).setCarnet(new Carnet(4L, Civilite.M, "Besson", "Luc", "1959-10-18", "+33618555723", "mohamed.chebbi@viacesi.fr", "75015", "Paris"));
        cs.add(new Carnet(4L, Civilite.M, "Besson", "Luc", "1959-10-18", "+33618555723", "mohamed.chebbi@viacesi.fr", "75015", "Paris"));
        cps.add(new Compte(4L,115122,"mohamed", "Lille"));

        compte1.setCarnet(contact1);
        compte2.setCarnet(contact2);
        compte3.setCarnet(contact3);

        cps.add(compte1);
        cps.add(compte2);
        cps.add(compte3);

        cs.add(contact1);
        cs.add(contact2);
        cs.add(contact3);
        return new ModelAndView("pages/Comptes").addObject("liste", cps.getAllComptes());

    }

}
