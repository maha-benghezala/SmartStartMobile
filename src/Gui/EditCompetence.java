/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Competence;
import Entities.Experience;
import Utils.WebService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Maha
 */
public class EditCompetence {
         Form f;
    static Competence r;
     Button ajouter;
   TextField nomcompetence ;
   
    public static int id ;
    public EditCompetence (){
    WebService ws = new WebService();
         f = new Form("");
        f = new Form("Liste Des competences");
         Toolbar tb = f.getToolbar();
          tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new CompetenceGui().getF();
        });
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
          new AjouterCompetenceGui().getForm();
        });
    
   nomcompetence= new TextField(r.getNomCompetence());   
     ajouter = new Button("Modifier");
      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(nomcompetence);
      
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        
        ajouter.addActionListener((e) -> {
           if(nomcompetence.getText()!= "" ){
            r.setNomCompetence(nomcompetence.getText());
           
            ws.EditResponseCompetence(r);
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
