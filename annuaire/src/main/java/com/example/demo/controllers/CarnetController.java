package com.example.demo.controllers;

import com.example.demo.entities.Carnet;
import com.example.demo.entities.Civilite;
import com.example.demo.services.CarnetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;


@RestController
public class CarnetController {

    @Autowired
    private CarnetServices cs;

    @RequestMapping("/AddCarnet")
    public ModelAndView ajoutCarnet() {
        cs.add(new Carnet(1L, Civilite.M, "Besson", "Luc", "1959-10-18", "+33618555723", "mohamed.chebbi@viacesi.fr", "75015", "Paris"));
        cs.add(new Carnet(2L, Civilite.MME, "Ullmann", "Liv", "1938-12-16", "+3361850423", "chebbimohamed1987@live.fr", "59800", "Tokyo"));
        cs.add(new Carnet(3L, Civilite.M, "Lynch", "David", "1946-01-20", "+3361850423", "chebbimohamed1987@gmail.com", "59801", "Missoula"));
        return new ModelAndView("redirect:/DisplayAll");
    }

    //function number 1 donnees brutes
    @RequestMapping("/Carnets")
    public ArrayList<Carnet> getAllCarnet() {
        return cs.getAllCarnets();
    }

    //function number 2 display tous les elements
    @GetMapping("/DisplayAll")
    public ModelAndView displayAll() {
        //return new ModelAndView("index.html").addObject("liste", cs.getAllCarnets());
        return new ModelAndView("pages/Carnets").addObject("liste", cs.getAllCarnets());
    }


    //function number 3 display iun seul element
    @RequestMapping(method = RequestMethod.GET, value = "/Carnet/{id}")
    public ModelAndView getById(@PathVariable long id) {

        return new ModelAndView("pages/Carnet").addObject("carnet", cs.findById(id));

    }


    @RequestMapping(value = "/getformulaire", method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("pages/formulaire").addObject("carnet", new Carnet());
    }


    @RequestMapping(method = RequestMethod.POST, value = "/formulaire")
    public ModelAndView getFormulaire(@Validated Carnet carnet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return new ModelAndView("pages/formulaire").addObject("carnet", carnet);
        }
        cs.add(carnet);
        return new ModelAndView("pages/Carnet").addObject("carnet", carnet);
    }


    @RequestMapping(value = "/Carnet/{id}", method = RequestMethod.DELETE)
    public ModelAndView delById(@PathVariable long id) {
        cs.delete(id);
        return new ModelAndView("redirect:/DisplayAll");
    }

    @RequestMapping(value = "/DeleteAll")
    public ModelAndView delAll() {
        cs.deletAll();
        return new ModelAndView("redirect:/DisplayAll");
    }


    @RequestMapping(value = "/Carnet/{id}", method = RequestMethod.PUT)
    public ModelAndView update(Carnet carnet) {

        cs.add(carnet);
        return new ModelAndView("redirect:/DisplayAll");
    }


   /* @RequestMapping(method = RequestMethod.POST, value = "/Affichage")
    public ModelAndView display(HttpServletRequest request) {
        String[] str = request.getParameterValues("maliste");
        System.out.println(str[0]);
        //long id=Long.parseLong(str);

        return new ModelAndView("pages/Carnet").addObject("carnet", cs.findById(2));
    }*/


}
