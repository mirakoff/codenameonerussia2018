/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import entity.Equipe;

import entity.Feuil;
import entity.FeuilDetail;
import entity.Matche;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;


//import org.json.simple.parser.ParseException;
/**
 *
 * @author Mirak
 */
public class ServiceFeuilDetail {
    public ArrayList<FeuilDetail> getListFeuilDetail(String json) {

        ArrayList<FeuilDetail> lstFeuilDetail = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> coms = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) coms.get("root");

            for (Map<String, Object> obj : list) {
                FeuilDetail FD = new FeuilDetail();
                
                LinkedHashMap Feu = (LinkedHashMap)obj.get("Feuil");
                Feuil feuil = new Feuil();
                feuil.setId((int)Float.parseFloat(Feu.get("id").toString()));
                feuil.setTitre(Feu.get("Titre").toString());
                feuil.setEtat(Feu.get("Etat").toString());
                
                
                LinkedHashMap mat = (LinkedHashMap)obj.get("matche");
                Matche match = new Matche();
                match.setId((int)Float.parseFloat(mat.get("id").toString()));
                   LinkedHashMap equip1 = (LinkedHashMap)mat.get("equipeA");
                   Equipe equi1 = new Equipe();
                           equi1.setId((int)Float.parseFloat(equip1.get("id").toString()));
                           equi1.setNom(equip1.get("nom").toString());
                           
                   LinkedHashMap equip2 = (LinkedHashMap)mat.get("equipeB");
                   Equipe equi2 = new Equipe();
                           equi2.setId((int)Float.parseFloat(equip2.get("id").toString()));
                           equi2.setNom(equip2.get("nom").toString());
                match.setEquipeA(equi1);
                match.setEquipeB(equi2);


                FD.setMatche(match);
                FD.setFeuil(feuil);
                FD.setTotal((int)Float.parseFloat(obj.get("Total").toString()));
                FD.setVotea((int)Float.parseFloat(obj.get("votea").toString()));
                FD.setVoteab((int)Float.parseFloat(obj.get("voteb").toString()));
                FD.setVoteb((int)Float.parseFloat(obj.get("voteab").toString()));
               
                
                

               // e.setEtat(obj.get("state").toString());
              //e.setNom(obj.get("name").toString());
                
                lstFeuilDetail.add(FD);

            }

        } catch (IOException ex) {
        }
        
        return lstFeuilDetail;

    }
    
     
}
