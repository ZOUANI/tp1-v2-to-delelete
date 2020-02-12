/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.bean;

import java.util.Objects;

/**
 *
 * @author MoulaYounes
 */
public class Compte {
    private String rib;
    private double solde;
    private char categorie;

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public char getCategorie() {
        return categorie;
    }

    public void setCategorie(char categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return   rib + "(" + solde + " : " + categorie + ')';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.rib);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compte other = (Compte) obj;
        if (!Objects.equals(this.rib, other.rib)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
