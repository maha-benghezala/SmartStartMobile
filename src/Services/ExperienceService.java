/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Experience;
import Utils.WebService;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class ExperienceService {
     public static ArrayList<Experience> getAllExperience(Map niv){
        ArrayList <Experience> experlist=new ArrayList<>();
         
        Map <String,Object> m=(Map <String,Object>) WebService.getResponse("experience/3");
        ArrayList a=(ArrayList) m.get("experience");
         System.out.println("ggggggg     "+a);
        for(int i=0;i<a.size();i++){
            System.out.println("ddddd");
           Map test =  (Map) a.get(i);
           Experience s=new Experience();
                    System.out.println("   heeeeeeeeeeeeeee");

           s.setId(((Double)test.get("id")).intValue());
           //s.setId_user(((Double)test.get("id_user")).intValue());
           s.setIntituleposte((String)test.get("intituleposte"));
           s.setNomentreprise((String)test.get("nomentreprise"));
           s.setSecteur((String)test.get("secteur"));
          
           s.setAnneedebut(((Double)test.get("anneedebut")).intValue()+"");
            if((Double)test.get("anneefin") != null){
           s.setAnneefin(((Double)test.get("anneefin")).intValue()+"");}
           s.setLieu((String)test.get("lieu"));
           s.setDescription((String)test.get("description"));
               
               experlist.add(s);
            
        }
        return experlist;
    }
}
