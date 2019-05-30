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
public class Certification {
      private  int id;
  private  int id_user;
  private  String nomcertif;
  private  String organisme,url;
  private  String moisd,moisf,anneed,anneef;

    public Certification(int id, int id_user, String nomcertif, String organisme, String url, String moisd, String moisf, String anneed, String anneef) {
        this.id = id;
        this.id_user = id_user;
        this.nomcertif = nomcertif;
        this.organisme = organisme;
        this.url = url;
        this.moisd = moisd;
        this.moisf = moisf;
        this.anneed = anneed;
        this.anneef = anneef;
    }

    public Certification() {
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

    public String getNomcertif() {
        return nomcertif;
    }

    public void setNomcertif(String nomcertif) {
        this.nomcertif = nomcertif;
    }

    public String getOrganisme() {
        return organisme;
    }

    public void setOrganisme(String organisme) {
        this.organisme = organisme;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMoisd() {
        return moisd;
    }

    public void setMoisd(String moisd) {
        this.moisd = moisd;
    }

    public String getMoisf() {
        return moisf;
    }

    public void setMoisf(String moisf) {
        this.moisf = moisf;
    }

    public String getAnneed() {
        return anneed;
    }

    public void setAnneed(String anneed) {
        this.anneed = anneed;
    }

    public String getAnneef() {
        return anneef;
    }

    public void setAnneef(String anneef) {
        this.anneef = anneef;
    }

    @Override
    public String toString() {
        return "Certification{" + "id=" + id + ", id_user=" + id_user + ", nomcertif=" + nomcertif + ", organisme=" + organisme + ", url=" + url + ", moisd=" + moisd + ", moisf=" + moisf + ", anneed=" + anneed + ", anneef=" + anneef + '}';
    }
  

}
