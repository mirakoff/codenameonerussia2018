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
public class Pronostique {
   private Matche matche;
    private Feuil Feuil;
    private User User;
    private String resulta;
    private Date dateInsertion;

    public Pronostique() {
    }

    public Pronostique(Matche matche, Feuil Feuil, User User, String resulta, Date dateInsertion) {
        this.matche = matche;
        this.Feuil = Feuil;
        this.User = User;
        this.resulta = resulta;
        this.dateInsertion = dateInsertion;
    }

    public Matche getMatche() {
        return matche;
    }

    public void setMatche(Matche matche) {
        this.matche = matche;
    }

    public Feuil getFeuil() {
        return Feuil;
    }

    public void setFeuil(Feuil Feuil) {
        this.Feuil = Feuil;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public String getResulta() {
        return resulta;
    }

    public void setResulta(String resulta) {
        this.resulta = resulta;
    }

    public Date getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(Date dateInsertion) {
        this.dateInsertion = dateInsertion;
    }
    
    
}
