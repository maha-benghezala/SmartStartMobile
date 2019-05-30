/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Experience;
import Entities.User;
import static Gui.CompetenceGui.id;
import Services.ExperienceService;
import Services.UserService;
import Utils.WebService;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class UserGui {
      public static int id ;
     Form f;
    Form f2;
    EncodedImage encoded;
    private String im ;
    public UserGui() {
       f = new Form("Freelancer");
         Toolbar tb = f.getToolbar();
           ImageViewer imv = null;
            Image img;
            EncodedImage encoded = null;
            try {
                encoded = EncodedImage.create("/DemandesCov.png");
            } catch (IOException ex) {
                //Logger.getLogger(GUIEvent.class.getName()).log(Level.SEVERE, null, ex);
            }
             

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
       
       tb.addMaterialCommandToRightBar("", FontImage.MATERIAL_CAMERA_ALT, e -> {
    Image screenshot = Image.createImage(f.getWidth(), f.getHeight());
        f.revalidate();
        f.setVisible(true);
        f.paintComponent(screenshot.getGraphics(), true);

        String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
        try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
            ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
        } catch(IOException err) {
            Log.e(err);
        }
       });
       

    WebService ws = new WebService();
   UserService rs = new UserService();
//    Map x = ws.getResponse("user");
 Map x = ws.getResponse("user");
    User u = MyApplication.currentUser;
        img = URLImage.createToStorage(encoded, u.getImage(), "http://localhost/smartStart/web/" + u.getImage());
            imv = new ImageViewer(img);
            Button b = new Button("Change l'image");
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
            Container ph1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label tit = new Label("Prenom : ");
            Label description = new Label("Nom: ");
            tit.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nb = new Label("Email : ");
            nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn = new Label("Poste  : ");
            nbn.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label nbn1 = new Label("Adresse : ");
            nbn1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label nbn2 = new Label("description   : ");
            nbn2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             
            
            Label l = new Label(u.getPrenom());
            SpanLabel l2 = new SpanLabel(u.getNom()+"");
              l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            l2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb = new Label(u.getEmail());
            lnb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
           Label lnb1 = new Label(u.getPoste()+"");
            lnb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             Label lnb2 = new Label(u.getAdresse()+"");
            lnb2.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            Label lnb3 = new Label(u.getDescription());
            lnb3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
            
          
            Container btn = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Button modifier = new Button("Modifier");
            Button delete = new Button("Supprimer");
            ph.add(imv);
            ph1.add(b);
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
            f.add(ph1);
            f.add(btn);
            
            modifier.addActionListener((e)->{
             
            });
            b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {

                try {
                    String fileNameInServer = "";
                    MultipartRequest cr = new MultipartRequest();
                    String filepath = Capture.capturePhoto(-1, -1);
                    cr.setUrl("http://localhost/uploadimage.php");
                    cr.setPost(true);
                    String mime = "image/jpeg";
                    cr.addData("file", filepath, mime);
                    String out = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                    cr.setFilename("file", out + ".jpg");//any unique name you want

                    fileNameInServer += out + ".jpg";
                    System.err.println("path2 =" + fileNameInServer);
                    im =fileNameInServer ;
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                } catch (IOException ex) {
                }
                MyApplication.currentUser.setImage(im);
                ws.changeImage();
                new UserGui().getF();
            }

        });
          
            
    
        
   
    f.show();
    }
   
     public Form getF() {
        return this.f;
    }
}
