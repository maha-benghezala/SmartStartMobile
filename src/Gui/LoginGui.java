/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Langue;
import Services.UserService;
import Utils.WebService;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.MyApplication;

/**
 *
 * @author Maha
 */
public class LoginGui {
       Form f;
    
    Button ajouter;
    TextField login ;
    TextField password ;
 
    public static int id ;
 
    public LoginGui(){
         f = new Form("");
         Toolbar tb = f.getToolbar();
         tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
          new LangueGui().getF();
        });


       
        ajouter = new Button("Se connecter");
        
        login = new TextField();
        login.setHint("Login");
        password=new TextField("",TextField.PASSWORD);
        password.setHint("Password ");
     
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        C2.addComponent(login);
        C2.addComponent(password);
       
        C2.addComponent(ajouter);
        f.add(C2);
        f.show();
        ajouter.addActionListener((e) -> {
            WebService ws = new WebService();
            ws.Login(login.getText());
               new UserGui().getF();
           
            
            
            
        });
    }
     public Form getForm() {
        return this.f;
    }
}
