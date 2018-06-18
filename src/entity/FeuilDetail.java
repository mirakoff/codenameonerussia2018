/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Mirak
 */
public class FeuilDetail {
    private Matche matche;
    private Feuil Feuil;
    private int Total;
    private int votea;
    private int voteb;
    private int voteab;

    public FeuilDetail() {
    }

    public FeuilDetail(Matche matche, Feuil Feuil, int Total, int votea, int voteb, int voteab) {
        this.matche = matche;
        this.Feuil = Feuil;
        this.Total = Total;
        this.votea = votea;
        this.voteb = voteb;
        this.voteab = voteab;
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

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public int getVotea() {
        return votea;
    }

    public void setVotea(int votea) {
        this.votea = votea;
    }

    public int getVoteb() {
        return voteb;
    }

    public void setVoteb(int voteb) {
        this.voteb = voteb;
    }

    public int getVoteab() {
        return voteab;
    }

    public void setVoteab(int voteab) {
        this.voteab = voteab;
    }
    
    
                                    
}
