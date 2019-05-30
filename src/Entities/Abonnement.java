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
public class Abonnement {
    private int id,iduser,identreprise;

    public Abonnement(int id, int iduser, int identreprise) {
        this.id = id;
        this.iduser = iduser;
        this.identreprise = identreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdentreprise() {
        return identreprise;
    }

    public void setIdentreprise(int identreprise) {
        this.identreprise = identreprise;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", iduser=" + iduser + ", identreprise=" + identreprise + '}';
    }
    
}
