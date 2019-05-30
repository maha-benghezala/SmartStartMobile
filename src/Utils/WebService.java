/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Entities.Certification;
import Entities.Competence;
import Entities.Experience;
import Entities.Formation;
import Entities.Langue;
import Entities.Rate;
import Entities.User;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.MyApplication;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class WebService {
     static Map h;
     Double Rate;
    
    public static Map<String, Object> getResponse(String url){
        url = "http://localhost/smartStart/web/app_dev.php/"+url;
        System.out.println(url);
        ConnectionRequest r = new ConnectionRequest(); 
        r.setUrl(url);
        r.setPost(false);
        System.out.println("url   :   "+r);
        InfiniteProgress prog = new InfiniteProgress();
        Dialog dlg = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(dlg);
        r.addResponseListener((evt) -> {
            try {
                JSONParser p = new JSONParser();
                Reader targetReader = new InputStreamReader(new ByteArrayInputStream(r.getResponseData()));
                System.out.println(targetReader);
                h= p.parseJSON(targetReader);
                System.out.println("h            ::::----------"+h);
                
            } catch (IOException ex) {
                //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        });
        NetworkManager.getInstance().addToQueueAndWait(r);
        return h; 
    }
    public void addResponse(Formation p){
        String user = p.getId_user()+"";
        System.out.println(user);
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/forma";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("nomecole", p.getNom_ecole());
     con.addArgument("diplome", p.getDiplome());
     con.addArgument("domaine", p.getDomaine());
     con.addArgument("anneediplome", p.getAnneediplome());
     con.addArgument("description",p.getDescription());
     
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                }); 
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void EditResponse(Formation p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/editforma";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("id", p.getId()+"");
    con.addArgument("nomecole", p.getNom_ecole());
     con.addArgument("diplome", p.getDiplome());
     con.addArgument("domaine", p.getDomaine());
     con.addArgument("anneediplome", p.getAnneediplome());
     con.addArgument("description",p.getDescription());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public void deleteResponse(int id){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/deleteforma/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void addResponseExperience(Experience e){
        String user = e.getId_user()+"";
        System.out.println(user);
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/ajoutexperience";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("poste", e.getIntituleposte());
     con.addArgument("entreprise", e.getNomentreprise());
     con.addArgument("lieu", e.getLieu());
     con.addArgument("anneedebut", e.getAnneedebut());
     
     con.addArgument("anneefin",e.getAnneefin());
     con.addArgument("secteur",e.getSecteur());
     con.addArgument("description",e.getDescription());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void EditResponseExperience(Experience p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/editexperience";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("id", p.getId()+"");
    con.addArgument("poste", p.getIntituleposte());
     con.addArgument("entreprise", p.getNomentreprise());
     con.addArgument("secteur", p.getSecteur());
     con.addArgument("anneedebut", p.getAnneedebut());
      con.addArgument("anneefin", p.getAnneefin());
       con.addArgument("lieu", p.getLieu());
     con.addArgument("description",p.getDescription());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public void deleteResponseExperience(int id){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/deleteexpe/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
        public void addResponseCertificat(Certification e){
        String user = e.getId_user()+"";
        System.out.println(user);
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/certificat";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("nomcert", e.getNomcertif());
     con.addArgument("organisme", e.getOrganisme());
     con.addArgument("moisd", e.getMoisd());
     con.addArgument("moisf", e.getMoisf());
     con.addArgument("anneed",e.getAnneed());
     con.addArgument("anneef",e.getAnneef());
     con.addArgument("url",e.getUrl());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void EditResponseCertificat(Certification p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/editcertificat";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("id", p.getId()+"");
    con.addArgument("nomcert", p.getNomcertif());
     con.addArgument("organisme", p.getOrganisme());
     con.addArgument("moisd", p.getMoisd());
     con.addArgument("moisf", p.getMoisf());
      con.addArgument("anneed", p.getAnneed());
       con.addArgument("anneef", p.getAnneef());
     con.addArgument("url",p.getUrl());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public void deleteResponseCertificat(int id){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/deletecertificat/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
          public void addResponseLangue(Langue e){
        String user = e.getId_user()+"";
        System.out.println(user);
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/langue";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("langue", e.getLangue());
     con.addArgument("niveau", e.getNiveau());
 
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void EditResponseLangue(Langue p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/editlangue";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("id", p.getId()+"");
    con.addArgument("langue", p.getLangue());
    con.addArgument("niveau", p.getNiveau());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public void deleteResponseLangue(int id){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/deletelanguee/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
             public void addResponseCompetence(Competence e){
        String user = e.getId_user()+"";
        System.out.println(user);
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/competence";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("nomcomp", e.getNomCompetence());
     
 
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
    public void EditResponseCompetence(Competence p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/editcompetence";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("id", p.getId()+"");
    con.addArgument("nomcomp", p.getNomCompetence());
  
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public void deleteResponseCompetence(int id){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/deletecompetence/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
      public static User Login(String username){
        String url = "http://localhost/smartStart/web/app_dev.php/log/"+username;
        System.out.println(url);
        User u = new User();
        ConnectionRequest r = new ConnectionRequest(); 
        r.setUrl(url);
        r.setPost(false);
        System.out.println("url   :   "+r);
       
        
                NetworkManager.getInstance().addToQueueAndWait(r);

        String response = new String(r.getResponseData());
        JSONParser jsonp = new JSONParser();
                try {
                    Map<String, Object> result = jsonp.parseJSON(new CharArrayReader(response.toCharArray()));
                    
                    u.setId((int)Float.parseFloat((result.get("id").toString())));
                    u.setNom(result.get("nom").toString());
                    u.setUsername(result.get("username").toString());
                    u.setAdresse(result.get("adresse").toString());
                    u.setDescription(result.get("description").toString());
                    u.setEmail(result.get("email").toString());
                    u.setPoste(result.get("poste").toString());
                    u.setPrenom(result.get("prenom").toString());
                    u.setImage(result.get("image").toString());
                } catch (IOException ex) {
                    u = null;
                }
 
        MyApplication.currentUser = u ;
        return u; 
    }
   public void AddRate(Rate p){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/adRateWS";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     con.addArgument("iduser", p.getIduser()+"");
    con.addArgument("userRated", p.getIduserrated()+"");
    con.addArgument("avis", p.getAvis()+"");
    con.addArgument("comm", p.getCommentaire());
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("Erreur", "erreur", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
   public void changeImage(){
        
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/changeImage";
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     con.addRequestHeader("X-Requested-With", "XMLHttpRequest");
     
     con.addArgument("image", MyApplication.currentUser.getImage());
     con.addArgument("user", MyApplication.currentUser.getId()+"");
 
     con.setPost(true);
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "success", "Ok", null);
                        } else {
                            Dialog.show("J", "J", "Ok", null);
                        }
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    
    }
   public Double getRate(int id){
        Rate =0.0;
        //String url = "http://127.0.0.1:8000/ajouterjson/"+p.getNom()+ "/" +p.getCategorie()+ "/" +p.getEmail()+ "/" +p.getType()+ "/" +p.getAdresse()+ "/" +p.getDescription()+ "/" +p.getSiteWeb()+ "/" +p.getPageFacebook()+ "/" +p.getPhone();
        String url = "http://localhost/smartStart/web/app_dev.php/affRate/"+id;
        ConnectionRequest con = new ConnectionRequest();
        
    
    
     con.setUrl(url);
     
        System.out.println(url);
      con.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        Rate = Double.parseDouble(s);
                        
                    }
                });
      /**
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
             });
        **/
        NetworkManager.getInstance().addToQueueAndWait(con);
    return Rate ;
    }
}
