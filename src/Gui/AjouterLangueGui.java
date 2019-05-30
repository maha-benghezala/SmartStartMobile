/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Formation;
import Entities.Langue;
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
public class AjouterLangueGui {
    Form f;
    
    Button ajouter;
    TextField langue ;
    TextField niveau ;
 
    public static int id ;
 
    public AjouterLangueGui(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new LangueGui().getF();
        });


       
        ajouter = new Button("Ajouter");
        
        langue = new TextField();
        langue.setHint("Nom Ecole");
        niveau = new TextField();
        niveau.setHint("Diplome ");
     
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(langue);
        C2.addComponent(niveau);
       
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        ajouter.addActionListener((e) -> {
            Langue r = new Langue();
            if(langue.getText()!="" && niveau.getText()!=""){
            r.setLangue(langue.getText());
            r.setNiveau(niveau.getText());
          
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseLangue(r);
            System.out.println("heeeeeeeeeeeey");
            new LangueGui();
             
            }else{
             Dialog.show("Error","Remplir les champs","error", null);
            }
        });
    }
     public Form getForm() {
        return this.f;
    }
}
