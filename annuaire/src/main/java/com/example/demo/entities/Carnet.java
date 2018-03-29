package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;


@Entity
@Table(name = "contact")
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)

    private Civilite civilite;

    @Pattern(regexp = "(?i)[a-z]{2,50}", message = "Ceci  ne respecte pas les informations a rentrer")
    private String nom;

    @Pattern(regexp = "(?i)[a-z\\- ]{2,10}", message = "Ceci  ne respecte pas les informations a rentrer")
    private String prenom;

    @NotBlank
    @DateTimeFormat
    @Column(columnDefinition = "date", length = 8, name = "Civillite")
    private String dateDeNaissance;

    @Pattern(regexp = "^([+]|[0]{2})[0-9]{4,14}(?:x.+)?$", message = "{com.example.demo.entities.Carnet.constraint.Tel.message}")
    @Column(name = "tel")
    private String tel;

    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "{com.example.demo.entities.Carnet.constraint.Email.message}")
    @Column(length = 100)
    private String email;

    @Pattern(regexp = "[0-9]{5}", message = "{com.example.demo.entities.Carnet.constraint.ZipCode.message}")
    @Column(name = "codePostal", length = 5)
    private String cp;

    @NotBlank
    @Column(length=50)
    @Pattern(regexp = "(?i)[a-z\\- ]{2,50}", message = "{com.example.demo.entities.Carnet.constraint.Town.message}")
    private String ville;


    public Carnet() { }




    public Carnet(Long id, Civilite civilite, String nom, String prenom, String dateDeNaissance, String tel,
                  String email, String cp, String ville) {

        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.tel = tel;
        this.email = email;
        this.cp = cp;
        this.ville = ville;
    }













    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}

