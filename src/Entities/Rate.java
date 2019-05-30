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
public class Rate {
       private int id ;
    private int iduserrated,iduser;
    private String Commentaire ;
    private int avis;

    public Rate(int id, int iduserrated, int iduser, String Commentaire, int avis) {
        this.id = id;
        this.iduserrated = iduserrated;
        this.iduser = iduser;
        this.Commentaire = Commentaire;
        this.avis = avis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduserrated() {
        return iduserrated;
    }

    public void setIduserrated(int iduserrated) {
        this.iduserrated = iduserrated;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Rate{" + "id=" + id + ", iduserrated=" + iduserrated + ", iduser=" + iduser + ", Commentaire=" + Commentaire + ", avis=" + avis + '}';
    }

    public Rate() {
    }
    
}
