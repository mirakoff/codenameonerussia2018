/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import entity.Feuil;
import services.ServiceFeuil;
import entity.Matche;
import entity.Pronostique;
import entity.User;
import java.io.IOException;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.SessionUser;


/**
 *
 * @author Mirak
 */
public class ServicePronostique {
     public ArrayList<Pronostique> getListPronostique(String json) {

        ArrayList<Pronostique> lstPronostique = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> coms = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) coms.get("root");

            for (Map<String, Object> obj : list) {
                Pronostique Pronostic = new Pronostique();

                
             //   JSONObject Feu = (JSONObject)obj.get("Feuil");
                //Feuil feuil = new Feuil();
            //    feuil.setId((int)Feu.get("id"));
                //Matche match = (Matche)obj.get("matche");
                //User user = (User)obj.get("User");
               // Date dateInsertion = (Date) obj.get("dateInsertion");
                String resulta = obj.get("resulta").toString();
                
                
              //  Pronostic.setFeuil(feuil);
                //Pronostic.setMatche(match);
                //Pronostic.setUser(user);
                //Pronostic.setDateInsertion(dateInsertion);
                Pronostic.setResulta(resulta);
                
                

               // e.setEtat(obj.get("state").toString());
              //e.setNom(obj.get("name").toString());
                
                lstPronostique.add(Pronostic);

            }

        } catch (IOException ex) {
        }
        
        return lstPronostique;

    }
     
     public String PronosticToJSON(Pronostique pros) throws JsonProcessingException  
     {
         Map<String, Object> Pronostic = new LinkedHashMap<>();
         Pronostic.put("resulta", pros.getResulta());
         ServiceFeuil sf = new ServiceFeuil();
         Pronostic.put("Feuil", sf.FeuilToJSON(pros.getFeuil()));
         ServiceMatche SM = new ServiceMatche();
         Pronostic.put("matche", SM.MatchToJSON(pros.getMatche()));
         ServiceUser Su = new ServiceUser();
         
         Pronostic.put("User", Su.UserToJSON(SessionUser.getInstance()));

         ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
         String json = ow.writeValueAsString(Pronostic);
         
         
        
         
       System.out.println(json);
         return json;
     }
}
