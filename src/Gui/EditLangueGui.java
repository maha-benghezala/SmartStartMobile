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
public class EditLangueGui {
      Form f;
    static Langue r;
     Button ajouter;
    TextField langue ;
    TextField niveau ;
    public static int id ;
    public EditLangueGui (){
    WebService ws = new WebService();
         f = new Form("");
        f = new Form("Liste Des Formations");
         Toolbar tb = f.getToolbar();
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
          new AjouterLangueGui().getForm();
        });
tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new LangueGui().getF();
        });
  
 langue = new TextField(r.getLangue());
        
        niveau = new TextField(r.getNiveau());
   
        
      
        ajouter = new Button("Modifier");
      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(langue);
        C2.addComponent(niveau);
       
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        
        ajouter.addActionListener((e) -> {
           if(langue.getText()!="" && niveau.getText()!=""){
            r.setLangue(langue.getText());
            r.setNiveau(niveau.getText());
           
            ws.EditResponseLangue(r);
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
