/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Feuil;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mirak
 */
public class ServiceFeuil {
    public Map<String,?> FeuilToJSON(Feuil feuil)
     {
         Map<String, Object> Feuil = new LinkedHashMap<>();
         Feuil.put("Id", feuil.getId());
         
         
         return Feuil;
     }
}
