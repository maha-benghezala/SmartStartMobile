
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Formation;
import Entities.User;
import Services.FormationService;
import Services.ListeEntreprise;
import Utils.WebService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
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
public class ListeEntrepriseGui {
   public static int id ;
     Form f;
    Form f2;
  
    EncodedImage encoded;
   
    public ListeEntrepriseGui(){
         f = new Form("Liste Des Entreprise");
         Toolbar tb = f.getToolbar();
       

Container topBar = BorderLayout.east(new Label(""));
topBar.add(BorderLayout.SOUTH, new Label("", "SidemenuTagline")); 
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);
tb.addMaterialCommandToSideMenu("Mes Informations", FontImage.MATERIAL_HOME, e -> {new UserGui();}); 
tb.addMaterialCommandToSideMenu("Formation", FontImage.MATERIAL_HOME, e -> {new FormationGui();}); 
tb.addMaterialCommandToSideMenu("Expérience", FontImage.MATERIAL_WEB, e -> {new ExperienceGui();});
tb.addMaterialCommandToSideMenu("Certification", FontImage.MATERIAL_SETTINGS, e -> {new CertificatGui();    });
tb.addMaterialCommandToSideMenu("Langue", FontImage.MATERIAL_BOOKMARK, e -> {new LangueGui();});
tb.addMaterialCommandToSideMenu("Compétence", FontImage.MATERIAL_INFO, e -> {new CompetenceGui();});
tb.addMaterialCommandToSideMenu("Liste des Entreprise", FontImage.MATERIAL_INFO, e -> {new ListeEntrepriseGui();});
       
       
tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> {
    AjouterFormationGui.id = id;
          new AjouterFormationGui().getForm();
        });
    WebService ws = new WebService();
   ListeEntreprise rs = new ListeEntreprise();
    Map x = ws.getResponse("entr");
    ArrayList<User> listevents = rs.getListEntreprise(x);
     if(listevents.size() != 0){
        
    for (User ev : listevents) {
        Double rate = ws.getRate(ev.getId());
            Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container sepa = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container title = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnbb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnnb1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ph = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label tit = new Label("nom Entreprise: ");
            Label description = new Label("Specialite : ");
            tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nb = new Label("Télephone : ");
            nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbb = new Label("Note : ");
            nbb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn = new Label("Adresse   : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn1 = new Label("description : ");
            nbn1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label l = new Label(ev.getNomsc());
            SpanLabel l2 = new SpanLabel(ev.getSpecialite()+"");
             
            Label lnb = new Label(ev.getTel()+"");
            lnb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnbb = new Label(rate+"");
            lnbb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb1 = new Label(ev.getAdresse()+"");
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label lnb2 = new Label(ev.getDescription()+"");
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            
           Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            
            l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            l2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
       
            title.add(tit);
            title.add(l);
            
            C2.add(description);
            C2.add(l2);
            
            ctnnb.add(nb);
            ctnnb.add(lnb);
            ctnnbb.add(nbb);
            ctnnbb.add(lnbb);
            ctnnnb.add(nbn);
            ctnnnb.add(lnb1);
            
            ctnnnb1.add(nbn1);
            ctnnnb1.add(lnb2);
           
            bouhom.add(ph);
            bouhom.add(title);
            bouhom.add(C2);
            bouhom.add(ctnnb);
            bouhom.add(ctnnbb);
            bouhom.add(ctnnnb);
            bouhom.add(ctnnnb1);
          Button ajouter = new Button("Voir");
            bouhom.add(sepa);
        btn.add(ajouter);
            bouhom.setLeadComponent(ph);
            
                        f.add(ComponentGroup.enclose(bouhom,btn));
          ajouter.addActionListener((e)->{
             AfficherEntreprise.r= ev ;
              new AfficherEntreprise().getF();
            });
           
            
    }
    }
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }


   
}