package com.example.demo.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "adresses")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(length = 6)
    private Integer number;
    @Column(length = 1000)
    private String street;
    @Column(length = 5)
    private Integer zipcode;
    @Column(length = 30)
    private String town;
    @ManyToMany (mappedBy = "adresses")
    private List<Carnet> carnets;

    public Adress(Long id, Integer number, String street, Integer zipcode, String town) {
        this.id= id;
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.town = town;
        carnets =  new ArrayList<>();
    }

    public Adress() {
        carnets =  new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public String getTown() {
        return town;
    }

    public List<Carnet> getCarnets() {
        return carnets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setCarnets(ArrayList<Carnet> carnets) {
        this.carnets = carnets;
    }

}
