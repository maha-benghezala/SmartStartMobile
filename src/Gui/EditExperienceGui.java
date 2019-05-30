/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

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
public class EditExperienceGui {
     Form f;
    static Experience r;
     Button ajouter;
   TextField poste ;
    TextField entreprise ;
    TextField secteur ;
    TextField anneedebut ;
    TextField anneefin ;
    TextField lieu ;
    TextArea description ;
    public static int id ;
    public EditExperienceGui (){
    WebService ws = new WebService();
         f = new Form("");
        f = new Form("Liste Des Formations");
         Toolbar tb = f.getToolbar();
          tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new ExperienceGui().getF();
        });
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
          new AjouterExperienceGui().getForm();
        });

   poste= new TextField(r.getIntituleposte());   
    entreprise  = new TextField(r.getNomentreprise());
   secteur = new TextField(r.getSecteur());
    anneedebut = new TextField(r.getAnneedebut());
    anneefin = new TextField(r.getAnneefin());
     lieu = new TextField(r.getLieu());
      
         description = new TextArea(r.getDescription());
        
      
        ajouter = new Button("Modifier");
      
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(poste);
        C2.addComponent(entreprise);
        C2.addComponent(secteur);
        C2.addComponent(anneedebut);
        C2.addComponent(anneefin);
        C2.addComponent(lieu);
        C2.addComponent(description);
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        
        ajouter.addActionListener((e) -> {
           if(poste.getText()!= "" && entreprise.getText()!="" && secteur.getText()!="" && anneedebut.getText()!="" && lieu.getText()!="" && lieu.getText()!="" ){
             if(anneefin.getText().length()==4 && anneefin.getText().length()==4) { 
            r.setIntituleposte(poste.getText());
            r.setNomentreprise(entreprise.getText());
            r.setSecteur(secteur.getText());
            r.setAnneedebut(anneedebut.getText());
            r.setAnneefin(anneefin.getText());
            r.setLieu(lieu.getText());
             r.setDescription(description.getText());
            ws.EditResponseExperience(r);
            System.out.println("heeeeeeeeeeeey");
            new ExperienceGui().getF();
              }else{
                 if(anneedebut.getText().length()==4 ) { 
          r.setIntituleposte(poste.getText());
            r.setNomentreprise(entreprise.getText());
            r.setSecteur(secteur.getText());
            r.setAnneedebut(anneedebut.getText());
            r.setAnneefin(anneefin.getText());
            r.setLieu(lieu.getText());
             r.setDescription(description.getText());
            ws.EditResponseExperience(r);
            System.out.println("heeeeeeeeeeeey");
            new ExperienceGui().getF();
            }else{
                     Dialog.show("Error","Corrigé votre date","error", null);
                 }
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
