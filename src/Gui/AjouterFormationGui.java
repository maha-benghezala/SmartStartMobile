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
import com.codename1.ui.Image;
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
public class AjouterFormationGui {
     Form f;
    
    Button ajouter;
    TextField nomecole ;
    TextField diplome ;
    TextField domaine ;
    TextField annediplome ;
    TextArea description ;
    public static int id ;
 
    public AjouterFormationGui(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new FormationGui().getF();
        });



       
        ajouter = new Button("Ajouter");
        
        nomecole = new TextField();
        nomecole.setHint("Nom Ecole");
        diplome = new TextField();
        diplome.setHint("Diplome ");
        domaine = new TextField();
        domaine.setHint("Domaine");
        annediplome = new TextField();
        annediplome.setHint("Année de Diplome ");
         description = new TextArea();
        description.setHint("Description ");
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
            Formation r = new Formation();
            if(nomecole.getText()!= "" && diplome.getText()!=null && domaine.getText()!=null && annediplome.getText()!=null  ){
             if(annediplome.getText().length()==4) {  
            
            r.setNom_ecole(nomecole.getText());
            r.setDiplome(diplome.getText());
           r.setDomaine(domaine.getText());
           r.setAnneediplome(annediplome.getText());
           r.setDescription(description.getText());
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponse(r);
            System.out.println("heeeeeeeeeeeey");
            new FormationGui();
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
