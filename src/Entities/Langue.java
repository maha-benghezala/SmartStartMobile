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
public class Langue {
     private int id;
   private int id_user;
   private String langue,niveau;

    public Langue(int id, int id_user, String langue, String niveau) {
        this.id = id;
        this.id_user = id_user;
        this.langue = langue;
        this.niveau = niveau;
    }

    public Langue() {
    
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Langue{" + "id=" + id + ", id_user=" + id_user + ", langue=" + langue + ", niveau=" + niveau + '}';
    }
   
}
