/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Competence;
import Entities.Langue;
import static Gui.AjouterLangueGui.id;
import Utils.WebService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Maha
 */
public class AjouterCompetenceGui {
      Form f;
    
    Button ajouter;
    TextField nomcompetence ;
    
 
    public static int id ;
 
    public AjouterCompetenceGui(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new CompetenceGui().getF();
        });


       
        ajouter = new Button("Ajouter");
        
        nomcompetence = new TextField();
        nomcompetence.setHint("Nom competence");
        
     
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(nomcompetence);
      
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        ajouter.addActionListener((e) -> {
            Competence r = new Competence();
             if(nomcompetence.getText()!= "" ){
            
            r.setNomCompetence(nomcompetence.getText());
            
          
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseCompetence(r);
            System.out.println("heeeeeeeeeeeey");
            new CompetenceGui();}else{
             Dialog.show("Error","Remplir les champs","error", null);
            }
        });
    }
     public Form getForm() {
        return this.f;
    }
}
