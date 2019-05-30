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
public class Contact {
    int id,id_user_recepteur,id_user_envoyer;
    String mail,message;

    public Contact(int id, int id_user_recepteur, int id_user_envoyer, String mail, String message) {
        this.id = id;
        this.id_user_recepteur = id_user_recepteur;
        this.id_user_envoyer = id_user_envoyer;
        this.mail = mail;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user_recepteur() {
        return id_user_recepteur;
    }

    public void setId_user_recepteur(int id_user_recepteur) {
        this.id_user_recepteur = id_user_recepteur;
    }

    public int getId_user_envoyer() {
        return id_user_envoyer;
    }

    public void setId_user_envoyer(int id_user_envoyer) {
        this.id_user_envoyer = id_user_envoyer;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", id_user_recepteur=" + id_user_recepteur + ", id_user_envoyer=" + id_user_envoyer + ", mail=" + mail + ", message=" + message + '}';
    }
    
}
