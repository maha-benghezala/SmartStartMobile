/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Formation;
import static Gui.AjouterFormationGui.id;
import Services.FormationService;
import Utils.WebService;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class FormationGui {
    public static int id ;
     Form f;
    Form f2;
  
    EncodedImage encoded;
   
    public FormationGui(){
         f = new Form("Liste Des Formations");
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
          new AjouterFormationGui().getForm();
        });
    WebService ws = new WebService();
   FormationService rs = new FormationService();
    Map x = ws.getResponse("formation/"+id);
    ArrayList<Formation> listevents = rs.getAllFormation(x);
     if(listevents.size() != 0){
        
    for (Formation ev : listevents) {
            Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container sepa = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container title = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ph = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label tit = new Label("nom ecole : ");
            Label description = new Label("diplome : ");
            tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nb = new Label("domaine : ");
            nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn = new Label("année   : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn1 = new Label("description : ");
            nbn1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label l = new Label(ev.getNom_ecole());
            SpanLabel l2 = new SpanLabel(ev.getDiplome()+"");
            Label lnb = new Label(ev.getDomaine());
            lnb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label lnb1 = new Label(ev.getAnneediplome()+"");
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb12 = new Label(ev.getDescription()+"");
            lnb12.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            
            l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            l2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Button modifier = new Button("Modifier");
            Button delete = new Button("Supprimer");
            title.add(tit);
            title.add(l);
            C2.add(description);
            C2.add(l2);
            ctnnb.add(nb);
            ctnnb.add(lnb);
            ctnnnb.add(nbn);
            ctnnnb.add(lnb1);
            ctnnnb1.add(nbn1);
            ctnnnb1.add(lnb12);
           
            bouhom.add(ph);
            bouhom.add(title);
            bouhom.add(C2);
            bouhom.add(ctnnb);
            bouhom.add(ctnnnb);
            bouhom.add(ctnnnb1);

            bouhom.add(sepa);
            btn.add(modifier);
            btn.add(delete);
            bouhom.setLeadComponent(ph);
            
                        f.add(ComponentGroup.enclose(bouhom,btn));

            
            modifier.addActionListener((e)->{
             EditFormationGui.r = ev ;
              new EditFormationGui().getForm();
            });
           delete.addActionListener((e) ->{
                ws.deleteResponse(ev.getId());
                new FormationGui().getF();
            });
            
    }
    }
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }

                 
                        
                        
                         
                        
                        
                        
                        
                        
                        
                        
                   
         
      
    
}
