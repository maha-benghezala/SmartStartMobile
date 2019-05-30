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
public class Competence {
      private  int id;
  private  int id_user;
  private  String nomCompetence;

    public Competence(int id, int id_user, String nomCompetence) {
        this.id = id;
        this.id_user = id_user;
        this.nomCompetence = nomCompetence;
    }

    public Competence() {
        
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

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    @Override
    public String toString() {
        return "Comp\u00e9tence{" + "id=" + id + ", id_user=" + id_user + ", nomCompetence=" + nomCompetence + '}';
    }
  
}
