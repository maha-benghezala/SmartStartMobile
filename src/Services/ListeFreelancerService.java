/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class ListeFreelancerService {
    public  ArrayList<User> getListFreelancer(Map m){
        ArrayList<User> listPropriete = new ArrayList<>();
        ArrayList d = (ArrayList)m.get("free");
        System.out.println("roooooooooot "+d);
        //Map f =  (Map) d.get(0);
        System.out.println("dddddddddddddd :::::::::"+d.size());

        for(int i = 0; i<d.size();i++){
            Map f =  (Map) d.get(i);
            User p = new User();
            Double ll = (Double) f.get("id");
            p.setId(ll.intValue());
            //Double l2 = (Double) f.get("nb_max");
            //e.setNb_max(l2.intValue());
            p.setPrenom((String) f.get("prenom"));
            p.setNom((String) f.get("nom"));
            p.setAdresse((String) f.get("adresse"));
           
            p.setEmail((String) f.get("email"));
            p.setTel((Double) f.get("tel"));
           
             p.setDescription((String) f.get("description"));
         
            
            /**
            e.setTitre((String) f.get("titre"));
            e.setDescription((String) f.get("description"));
            e.setCategorie((String) f.get("categorie"));
            e.setPhoto((String) f.get("photo"));
            e.setDateDebut((Date)f.get("dateDebut"));
            e.setDateFin((Date)f.get("dateFin"));
            //e.setCreatedAt((Date)f.get("createdAt"));
            e.setLieu((String) f.get("lieu"));
            
            e.setNb_max(((Double) f.get("nbMax")).intValue());**/
            listPropriete.add(p);  
        }        
        return listPropriete;
        
    }
}
