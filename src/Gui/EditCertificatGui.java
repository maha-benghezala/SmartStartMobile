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
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.GenericListCellRenderer;

/**
 *
 * @author Maha
 */
public class EditCertificatGui {
        Form f;
    static Certification r;
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
    public EditCertificatGui (){
    WebService ws = new WebService();
         f = new Form("");
        f = new Form("Liste Certificat");
         Toolbar tb = f.getToolbar();
          tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new CertificatGui().getF();
        });
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
          new AjouterCertificatGUI().getForm();
        });
   
   nomcertif= new TextField(r.getNomcertif());   
    organisme  = new TextField(r.getOrganisme());
   moisd = new ComboBox<String>();
    moisf = new ComboBox<String>();
    anneed = new TextField(r.getAnneed());
     anneef = new TextField(r.getAnneef());
      
         url = new TextArea(r.getUrl());
        
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
        ajouter = new Button("Modifier");
      
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
            if(nomcertif.getText()!= "" && organisme.getText()!= "" && moisd.getSelectedItem()!=null && anneed.getText()!=""){
             if(anneed.getText().length()==4 && anneef.getText().length()==4 && Integer.parseInt(anneef.getText())>Integer.parseInt(anneed.getText() )) { 
              
            r.setNomcertif(nomcertif.getText());
            r.setOrganisme(organisme.getText());
            r.setMoisd(moisd.getSelectedItem());
            r.setMoisf(moisf.getSelectedItem());
            r.setAnneed(anneed.getText());
            r.setAnneef(anneef.getText());
             r.setUrl(url.getText());
            ws.EditResponseCertificat(r);
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
            ws.EditResponseCertificat(r);
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
