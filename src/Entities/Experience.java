/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Maha
 */
public class Experience {
     private int id;
    private int id_user;
    private String nomentreprise;
    private String intituleposte;
    private String secteur;
    private String anneedebut;
    private String anneefin;
    private String lieu;
    private String description;

    public Experience(int id, int id_user, String nomentreprise, String intituleposte, String secteur, String anneedebut, String anneefin, String lieu, String description) {
        this.id = id;
        this.id_user = id_user;
        this.nomentreprise = nomentreprise;
        this.intituleposte = intituleposte;
        this.secteur = secteur;
        this.anneedebut = anneedebut;
        this.anneefin = anneefin;
        this.lieu = lieu;
        this.description = description;
    }

    public Experience() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getIntituleposte() {
        return intituleposte;
    }

    public void setIntituleposte(String intituleposte) {
        this.intituleposte = intituleposte;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getAnneedebut() {
        return anneedebut;
    }

    public void setAnneedebut(String anneedebut) {
        this.anneedebut = anneedebut;
    }

    public String getAnneefin() {
        return anneefin;
    }

    public void setAnneefin(String anneefin) {
        this.anneefin = anneefin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", id_user=" + id_user + ", nomentreprise=" + nomentreprise + ", intituleposte=" + intituleposte + ", secteur=" + secteur + ", anneedebut=" + anneedebut + ", anneefin=" + anneefin + ", lieu=" + lieu + ", description=" + description + '}';
    }
    
}
