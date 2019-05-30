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
public class AjouterExperienceGui {
       Form f;
    
    Button ajouter;
    TextField poste ;
    TextField entreprise ;
    TextField secteur ;
    TextField anneedebut ;
    TextField anneefin ;
    TextField lieu ;
    TextArea description ;

    public static int id ;
 
    public AjouterExperienceGui(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new ExperienceGui().getF();
        });


       
        ajouter = new Button("Ajouter");
        
        poste = new TextField();
        poste.setHint("Poste");
        entreprise = new TextField();
        entreprise.setHint("Entreprise ");
        secteur = new TextField();
        secteur.setHint("Secteur");
        anneedebut = new TextField();
        anneedebut.setHint("Année de debut ");
        anneefin = new TextField();
        anneefin.setHint("Année de Fin ");
        lieu = new TextField();
        lieu.setHint("Lieu ");
         description = new TextArea();
        description.setHint("Description ");
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
            Experience r = new Experience();
             if(poste.getText()!= "" && entreprise.getText()!="" && secteur.getText()!="" && anneedebut.getText()!="" && lieu.getText()!="" && lieu.getText()!="" ){
             if(anneedebut.getText().length()==4 && anneefin.getText().length()==4 && Integer.parseInt(anneedebut.getText())<Integer.parseInt(anneefin.getText())) { 
            r.setIntituleposte(poste.getText());
            r.setNomentreprise(entreprise.getText());
           r.setSecteur(secteur.getText());
           r.setAnneedebut(anneedebut.getText());
           r.setAnneefin(anneefin.getText());
           r.setLieu(lieu.getText());
           
           r.setDescription(description.getText());
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseExperience(r);
            System.out.println("heeeeeeeeeeeey");
            new ExperienceGui().getF();
            }else{
                 if(anneedebut.getText().length()==4 ) { 
                       r.setIntituleposte(poste.getText());
            r.setNomentreprise(entreprise.getText());
           r.setSecteur(secteur.getText());
           r.setAnneedebut(anneedebut.getText());
           
           r.setLieu(lieu.getText());
           
           r.setDescription(description.getText());
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseExperience(r);
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
