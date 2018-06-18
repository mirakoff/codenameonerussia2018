/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Matche;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mirak
 */
public class ServiceMatche {
    public Map<String,?> MatchToJSON(Matche match)
     {
         Map<String, Object> Matche = new LinkedHashMap<>();
         Matche.put("Id", match.getId());
         
         
         return Matche;
     }
}
