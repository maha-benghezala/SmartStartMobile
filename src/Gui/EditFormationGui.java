/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Formation;
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
public class EditFormationGui {
    Form f;
    static Formation r;
     Button ajouter;
    TextField nomecole ;
    TextField diplome ;
    TextField domaine ;
    TextField annediplome ;
    TextArea description ;
    public static int id ;
    public EditFormationGui (){
    WebService ws = new WebService();
         f = new Form("");
        f = new Form("Liste Des Formations");
         Toolbar tb = f.getToolbar();
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
          new AjouterFormationGui().getForm();
        });
tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new FormationGui().getF();
        });
    
 nomecole = new TextField(r.getNom_ecole());
        
        diplome = new TextField(r.getDiplome());
       
        domaine = new TextField(r.getDomaine());
        
        annediplome = new TextField(r.getAnneediplome());
      
         description = new TextArea(r.getDescription());
        
      
        ajouter = new Button("Modifier");
      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(nomecole);
        C2.addComponent(diplome);
        C2.addComponent(domaine);
        C2.addComponent(annediplome);
        C2.addComponent(description);
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        
        ajouter.addActionListener((e) -> {
             if(nomecole.getText()!= "" && diplome.getText()!=null && domaine.getText()!=null && annediplome.getText()!=null  ){
             if(annediplome.getText().length()==4) { 
            r.setNom_ecole(nomecole.getText());
            r.setDiplome(diplome.getText());
            r.setDomaine(domaine.getText());
            r.setAnneediplome(annediplome.getText());
             r.setDescription(description.getText());
            ws.EditResponse(r);
            System.out.println("heeeeeeeeeeeey");
            new FormationGui().getF();
               }else{
                  Dialog.show("Error","Corrigé votre date","error", null);
             }
            }else{
             Dialog.show("Error","Remplir les champs","error", null);
            }
        });
             
    }

     public Form getForm() {
        return this.f;
    }
}
