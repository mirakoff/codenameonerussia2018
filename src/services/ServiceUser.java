/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import entity.User;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirak
 */
public class ServiceUser {
    public User getUserConnecte(String json) {

        User user = new User();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> userConnecter = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) userConnecter.get("root");

            for (Map<String, Object> obj : list) {
                User e = new User();

                float id = Float.parseFloat(obj.get("id").toString());
                
                user.setId((int) id);

               // user.setUsername(obj.get("username").toString());
                
                //récuperer role
//                 ArrayList<String> role = <String> obj.get("roles");
//                 System.out.println(role.get("ROLE_USER").toString());
//                e.setRoles(role.get("ROLE_USER").toString());
                
                System.out.println(e);
                

            }

        } catch (IOException ex) {
        }
       // System.out.println(listEtudiants);
        return user;

    }
    
    public Map<String,?> UserToJSON(User user)
     {
         Map<String, Object> User = new LinkedHashMap<>();
         User.put("Id", user.getId());
         
         
         return User;
     }
    
}
