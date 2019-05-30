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
public class Formation {
     private int id;
    private int id_user;
    private String nom_ecole;
    private String diplome;
    private String domaine;
    private String anneediplome;

    private String description;

    public Formation() {
    }

    public Formation(int id, int id_user, String nom_ecole, String diplome, String domaine, String anneediplome) {
        this.id = id;
        this.id_user = id_user;
        this.nom_ecole = nom_ecole;
        this.diplome = diplome;
        this.domaine = domaine;
        this.anneediplome = anneediplome;
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

    public String getNom_ecole() {
        return nom_ecole;
    }

    public void setNom_ecole(String nom_ecole) {
        this.nom_ecole = nom_ecole;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getAnneediplome() {
        return anneediplome;
    }

    public void setAnneediplome(String anneediplome) {
        this.anneediplome = anneediplome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", id_user=" + id_user + ", nom_ecole=" + nom_ecole + ", diplome=" + diplome + ", domaine=" + domaine + ", anneediplome=" + anneediplome + ", description=" + description + '}';
    }
    
}
