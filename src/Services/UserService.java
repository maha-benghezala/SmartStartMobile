/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Competence;
import Entities.User;
import Utils.WebService;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Maha
 */
public class UserService {
      public static User getAllInformation(Map niv){
          User u = new User();
        User d = (User)niv.get("user");
        System.out.println("roooooooooot "+d);
        //Map f =  (Map) d.get(0);

        
        return d;
    }
}
