/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Langue;
import Utils.WebService;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class LangueService {
    public static ArrayList<Langue> getAllLangue(Map niv){
        ArrayList <Langue> languelist=new ArrayList<>();
        Map <String,Object> m=(Map <String,Object>) WebService.getResponse("langue/3");
        ArrayList a=(ArrayList) m.get("langue");
         System.out.println("ggggggg     "+a);
        for(int i=0;i<a.size();i++){
            
           Map test =  (Map) a.get(i);
           Langue s=new Langue();
                    System.out.println("   heeeeeeeeeeeeeee");

           s.setId(((Double)test.get("id")).intValue());
           //s.setId_user(((Double)test.get("id_user")).intValue());
           s.setLangue((String)test.get("langue"));
           s.setNiveau((String)test.get("niveau"));
          
               languelist.add(s);
            
        }
        return languelist;
    }
}
