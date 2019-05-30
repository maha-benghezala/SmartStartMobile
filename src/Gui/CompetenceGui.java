/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Competence;
import Entities.Langue;
import Services.CompetenceService;
import Services.LangueService;
import Utils.WebService;
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
public class CompetenceGui {
      public static int id ;
     Form f;
    Form f2;
  
    EncodedImage encoded;
   
    public CompetenceGui(){
         f = new Form("Liste des Competences");
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
    AjouterFormationGui.id = id;
       new AjouterCompetenceGui().getForm();
        });
    WebService ws = new WebService();
  CompetenceService rs = new CompetenceService();
    Map x = ws.getResponse("competence/"+id);
    ArrayList<Competence> listevents = rs.getAllCompetence(x);
     if(listevents.size() != 0){
        
    for (Competence ev : listevents) {
            Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container sepa = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container title = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ph = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label tit = new Label("Nom Competence : ");
             tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           
           
            Label lnb1 = new Label(ev.getNomCompetence());
           
          
          
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           
           Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Button modifier = new Button("Modifier");
            Button delete = new Button("Supprimer");
           
            title.add(tit);
           title.add(lnb1);
         
            
          
           
            btn.add(modifier);
            btn.add(delete);
            bouhom.add(ph);
            bouhom.add(title);
            bouhom.add(C2);
          
            bouhom.add(ctnnnb);
           

            bouhom.add(sepa);

            bouhom.setLeadComponent(ph);
            f.add(bouhom);
            
            f.add(btn);
            
            modifier.addActionListener((e)->{
              EditCompetence.r = ev ;
              new EditCompetence().getForm();
            });
          delete.addActionListener((e) ->{
                ws.deleteResponseCompetence(ev.getId());
                new CompetenceGui().getF();
            });
            
    }
    }
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }
}
