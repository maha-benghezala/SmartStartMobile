/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Competence;
import Utils.WebService;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class CompetenceService {
         public static ArrayList<Competence> getAllCompetence(Map niv){
        ArrayList <Competence> complist=new ArrayList<>();
         
        Map <String,Object> m=(Map <String,Object>) WebService.getResponse("competence/3");
        ArrayList a=(ArrayList) m.get("competence");
         System.out.println("ggggggg     "+a);
        for(int i=0;i<a.size();i++){
            System.out.println("ddddd");
           Map test =  (Map) a.get(i);
           Competence s=new Competence();
                    System.out.println("   heeeeeeeeeeeeeee");

           s.setId(((Double)test.get("id")).intValue());
           //s.setId_user(((Double)test.get("id_user")).intValue());
           s.setNomCompetence((String)test.get("nomcompetence"));
               complist.add(s);
            
        }
        return complist;
    }
}
