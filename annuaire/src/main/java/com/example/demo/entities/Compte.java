package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "compte")

public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_client")
    private Integer numero;
    @Column(name = "nom_client")
    private String customerName;
    @Column(name = "agence")
    private String bankOffice;

    @ManyToOne
    @JoinColumn(name = "carnet")
   // @JoinTable(name="carnet", joinColumns = )

    private Carnet carnet;

    public Compte() {

    }

    public Compte(Long id, Integer numero, String customerName, String bankOffice) {
        this.numero = numero;
        this.customerName = customerName;
        this.bankOffice = bankOffice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBankOffice() {
        return bankOffice;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBankOffice(String bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumero() {
        return numero;
    }


    public Carnet getCarnet() {
        return carnet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
}
