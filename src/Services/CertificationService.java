/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Certification;
import Utils.WebService;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class CertificationService {
        public static ArrayList<Certification> getAllCertification(Map niv){
        ArrayList <Certification> certlist=new ArrayList<>();
         
        Map <String,Object> m=(Map <String,Object>) WebService.getResponse("certifica/3");
        ArrayList a=(ArrayList) m.get("certificat");
         System.out.println("ggggggg     "+a);
        for(int i=0;i<a.size();i++){
            System.out.println("ddddd");
           Map test =  (Map) a.get(i);
           Certification s=new Certification();
                    System.out.println("   heeeeeeeeeeeeeee");

           s.setId(((Double)test.get("id")).intValue());
           //s.setId_user(((Double)test.get("id_user")).intValue());
           s.setNomcertif((String)test.get("nomcertif"));
           s.setOrganisme((String)test.get("organisme"));
           s.setMoisd((String)test.get("moisdebut"));
           if((String)test.get("moisfin") != ""){
           s.setMoisf((String)test.get("moisfin"));
           }
            
           s.setAnneed(((Double)test.get("anneedebut")).intValue()+"");
         if((Double)test.get("anneefin") != null){
           s.setAnneef(((Double)test.get("anneefin")).intValue()+"");
           }
           s.setUrl((String)test.get("url"));
               
               certlist.add(s);
            
        }
        return certlist;
    }
}
