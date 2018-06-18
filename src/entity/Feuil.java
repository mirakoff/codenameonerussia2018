/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Mirak
 */
public class Feuil {
     private int id;
     private String Etat;
     private String Titre;
     private Date DateF;

    public Feuil() {
    }

    public Feuil(int id, String Etat, String Titre, Date DateF) {
        this.id = id;
        this.Etat = Etat;
        this.Titre = Titre;
        this.DateF = DateF;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public Date getDateF() {
        return DateF;
    }

    public void setDateF(Date DateF) {
        this.DateF = DateF;
    }
     
}
