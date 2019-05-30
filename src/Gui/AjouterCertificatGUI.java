/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Entities.Certification;
import Entities.Experience;
import Utils.WebService;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.List;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class AjouterCertificatGUI {
    Form f;
    
    Button ajouter;
    TextField nomcertif;
    TextField  organisme;
    TextArea url;
    TextField anneed,anneef;
   ComboBox <String> moisd; 
   ComboBox <String> moisf; 

    public static int id ;
      private String createListEntry( String entry) {
   return entry ;}
   
    public AjouterCertificatGUI(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new CertificatGui().getF();
        });


       
        ajouter = new Button("Ajouter");
        
        nomcertif = new TextField();
        nomcertif.setHint("Nom de Certificat");
        organisme = new TextField();
        organisme.setHint("Organisme ");
   
         moisd = new ComboBox<> (
          createListEntry("Janvier"),
          createListEntry("Février"),
          createListEntry("Mars"),
          createListEntry("Avril"),
          createListEntry("Mai"),
          createListEntry("Juin"),
          createListEntry("Juillet"),
          createListEntry("Aout"),
          createListEntry("Septembre"),
          createListEntry("October"),
          createListEntry("Nouvembre"),
          createListEntry("Décember"));
     

           moisf = new ComboBox<> (
          createListEntry("Janvier"),
          createListEntry("Février"),
          createListEntry("Mars"),
          createListEntry("Avril"),
          createListEntry("Mai"),
          createListEntry("Juin"),
          createListEntry("Juillet"),
          createListEntry("Aout"),
          createListEntry("Septembre"),
          createListEntry("October"),
          createListEntry("Nouvembre"),
          createListEntry("Décember"));
     
        
       
        
        anneed = new TextField();
        anneed.setHint("Année Debut ");
        anneef = new TextField();
        anneef.setHint("Année de Diplome ");
       
         url = new TextArea();
        url.setHint("Description ");
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(nomcertif);
        C2.addComponent(organisme);
        C2.addComponent(moisd);
        C2.addComponent(moisf);
        C2.addComponent(anneed);
        C2.addComponent(anneef);
        C2.addComponent(url);
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        ajouter.addActionListener((e) -> {
           
           Certification r = new Certification();
           if(nomcertif.getText()!= "" && organisme.getText()!= "" && moisd.getSelectedItem()!=null && anneed.getText()!=""){
             if(anneed.getText().length()==4 && anneef.getText().length()==4 && Integer.parseInt(anneef.getText())>Integer.parseInt(anneed.getText() )) { 
              
            r.setNomcertif(nomcertif.getText());
            r.setOrganisme(organisme.getText());
           r.setMoisd(moisd.getSelectedItem());
           r.setMoisf(moisf.getSelectedItem());
           r.setAnneed(anneed.getText());
           r.setAnneef(anneef.getText());
           
           r.setUrl(url.getText());
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseCertificat(r);
            System.out.println("heeeeeeeeeeeey");
             }else{
                  if(anneed.getText().length()==4  && moisd.getSelectedItem()!=null) {
                      r.setNomcertif(nomcertif.getText());
            r.setOrganisme(organisme.getText());
           r.setMoisd(moisd.getSelectedItem());
           r.setMoisf(moisf.getSelectedItem());
           r.setAnneed(anneed.getText());
           r.setAnneef(anneef.getText());
           
           r.setUrl(url.getText());
            r.setId_user(id);
            WebService ws = new WebService();
            ws.addResponseCertificat(r);
            System.out.println("heeeeeeeeeeeey");
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
