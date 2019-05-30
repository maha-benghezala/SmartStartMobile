/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Langue;
import Entities.Rate;
import Entities.User;
import Services.UserService;
import Utils.WebService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class AfficherEntreprise {
     public static int id ;
     Form f;
    Form f2;
    static User r;
    EncodedImage encoded;
    Button ajouter;
    public AfficherEntreprise() {
       f = new Form("Entreprise");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new ListeEntrepriseGui().getF();
        });

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
//    AjouterExperienceGui.id = id;
//          new AjouterExperienceGui().getForm();
        });
    WebService ws = new WebService();
   UserService rs = new UserService();
//    Map x = ws.getResponse("user");
 Map x = ws.getResponse("user");
    User u = MyApplication.currentUser;
    Slider rate = createStarRankSlider();
    ajouter = new Button("Ajouter");
        TextArea comm = new TextArea();
        comm.setHint("Ajouter un commentaire");
        
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
            Label tit = new Label("Nom Entreprise : ");
            Label description = new Label("Specialite :  ");
            tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nb = new Label("Télephone");
            nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label nbn1 = new Label("Adresse : ");
            nbn1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label nbn2 = new Label("description   : ");
            nbn2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             
            
            Label l = new Label(r.getNomsc());
            SpanLabel l2 = new SpanLabel(r.getSpecialite()+"");
              l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            l2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb = new Label(r.getTel()+"");
            lnb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label lnb1 = new Label(u.getAdresse());
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
         
             Label lnb3 = new Label(u.getDescription());
            lnb3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            
          
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

          
          
            title.add(tit);
            title.add(l);
            
            C2.add(description);
            C2.add(l2);
            
            ctnnb.add(nb);
            ctnnb.add(lnb);
            
            ctnnnb.add(nbn1);
            ctnnnb.add(lnb1);
            ctnnnb1.add(nbn2);
            ctnnnb1.add(lnb3);
            
            
               
           
            bouhom.add(ph);
            bouhom.add(title);
            bouhom.add(C2);
            bouhom.add(ctnnb);
            bouhom.add(ctnnnb);
            bouhom.add(ctnnnb1);
 
            bouhom.add(sepa);

            bouhom.setLeadComponent(ph);
            Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    C5.add(FlowLayout.encloseCenter(rate));
    C5.add(comm);
    C5.addComponent(ajouter);
            f.add(bouhom);
            
            f.add(btn);
            f.add(C5);
       ajouter.addActionListener((e) -> {
        int avis = rate.getProgress() / 2;
        Rate r = new Rate();
        r.setAvis(avis);
        r.setCommentaire(comm.getText());
        r.setIduser(MyApplication.currentUser.getId());
        r.setIduserrated(r.getId());
        ws.AddRate(r);
    });
            
    
        
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }
      private void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }
     private Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        return starRank;
    }
}
