/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Formation;
import Utils.WebService;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class FormationService {
     public static ArrayList<Formation> getAllFormation(Map niv){
        ArrayList <Formation> formationlist=new ArrayList<>();
        Map <String,Object> m=(Map <String,Object>) WebService.getResponse("formation/3");
        ArrayList a=(ArrayList) m.get("formation");
         System.out.println("ggggggg     "+a);
        for(int i=0;i<a.size();i++){
            
           Map test =  (Map) a.get(i);
           Formation s=new Formation();
                    System.out.println("   heeeeeeeeeeeeeee");

           s.setId(((Double)test.get("id")).intValue());
           //s.setId_user(((Double)test.get("id_user")).intValue());
           s.setNom_ecole((String)test.get("nomecole"));
           s.setDomaine((String)test.get("domaine"));
           s.setDiplome((String)test.get("diplome"));
           s.setAnneediplome(((Double)test.get("anneediplome")).intValue()+"");
               s.setDescription((String)test.get("description"));
               formationlist.add(s);
            
        }
        return formationlist;
    }
    
}
