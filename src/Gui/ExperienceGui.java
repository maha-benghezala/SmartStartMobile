/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Experience;
import Entities.Formation;
import static Gui.FormationGui.id;
import Services.ExperienceService;
import Services.FormationService;
import Utils.WebService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class ExperienceGui {
    public static int id ;
     Form f;
    Form f2;
  
    EncodedImage encoded;
    public ExperienceGui() {
       f = new Form("Liste Des Experiences");
         Toolbar tb = f.getToolbar();
         
Container topBar = BorderLayout.east(new Label(""));
topBar.add(BorderLayout.SOUTH, new Label("", "SidemenuTagline")); 
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);
tb.addMaterialCommandToSideMenu("Mes Informations", FontImage.MATERIAL_ACCOUNT_BOX, e -> {new UserGui();});
tb.addMaterialCommandToSideMenu("Formation", FontImage.MATERIAL_HOME, e -> {new FormationGui();}); 
tb.addMaterialCommandToSideMenu("Expérience", FontImage.MATERIAL_WEB, e -> {new ExperienceGui();});
tb.addMaterialCommandToSideMenu("Certification", FontImage.MATERIAL_SETTINGS, e -> {new CertificatGui();});
tb.addMaterialCommandToSideMenu("Langue", FontImage.MATERIAL_INFO, e -> {new LangueGui();});
tb.addMaterialCommandToSideMenu("Compétence", FontImage.MATERIAL_INFO, e -> {new CompetenceGui();});
tb.addMaterialCommandToSideMenu("Liste Entreprise", FontImage.MATERIAL_INFO, e -> {new ListeEntrepriseGui();});
       
       
       
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
    AjouterExperienceGui.id = id;
          new AjouterExperienceGui().getForm();
        });
    WebService ws = new WebService();
   ExperienceService rs = new ExperienceService();
    Map x = ws.getResponse("experience/"+id);
    ArrayList<Experience> listevents = rs.getAllExperience(x);
     if(listevents.size() != 0){
        
    for (Experience ev : listevents) {
            Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container sepa = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container title = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ph = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label tit = new Label("Poste : ");
            Label description = new Label("Nom Entreprise : ");
            tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nb = new Label("Secteur : ");
            nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn = new Label("année debut   : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn1 = new Label("annee fin : ");
            nbn1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label nbn2 = new Label("lieu   : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label nbn3 = new Label("description  : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            
            
            Label l = new Label(ev.getIntituleposte());
            SpanLabel l2 = new SpanLabel(ev.getNomentreprise()+"");
            Label lnb = new Label(ev.getSecteur());
            lnb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label lnb1 = new Label(ev.getAnneedebut()+"");
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label lnb2 = new Label(ev.getAnneefin()+"");
            lnb2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb3 = new Label(ev.getLieu());
            lnb3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb4 = new Label(ev.getDescription());
            lnb4.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
          
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Button modifier = new Button("Modifier");
            Button delete = new Button("Supprimer");
            l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            l2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            title.add(tit);
            title.add(l);
            
            C2.add(description);
            C2.add(l2);
            
            ctnnb.add(nb);
            ctnnb.add(lnb);
            
            ctnnnb.add(nbn);
            ctnnnb.add(lnb1);
            
            ctnnnb1.add(nbn1);
            ctnnnb1.add(lnb2);
            
            ctnnnb2.add(nbn2);
            ctnnnb2.add(lnb3);
            
             ctnnnb3.add(nbn3);
              ctnnnb3.add(lnb4);
               
            btn.add(modifier);
            btn.add(delete);
            bouhom.add(ph);
            bouhom.add(title);
            bouhom.add(C2);
            bouhom.add(ctnnb);
            bouhom.add(ctnnnb);
            bouhom.add(ctnnnb1);
            bouhom.add(ctnnnb2);
            bouhom.add(ctnnnb3);

            bouhom.add(sepa);

            bouhom.setLeadComponent(ph);
            f.add(bouhom);
            
            f.add(btn);
            
            modifier.addActionListener((e)->{
              EditExperienceGui.r = ev ;
              new EditExperienceGui().getForm();
            });
          delete.addActionListener((e) ->{
                ws.deleteResponseExperience(ev.getId());
                new ExperienceGui().getF();
            });
            
    }
    }
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }
    
}
