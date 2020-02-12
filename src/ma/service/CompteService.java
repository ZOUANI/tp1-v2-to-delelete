/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import ma.bean.Compte;
import java.util.List;

/**
 *
 * @author MoulaYounes
 */
public class CompteService {

    public int findByIndex(String rib, List<Compte> comptes) {
        for (int i = 0; i < comptes.size(); i++) {
            Compte c = comptes.get(i);
            if (c.getRib().equals(rib)) {
                return i;
            }
        }
        return -1;
    }

    public int save(String rib, double solde, List<Compte> comptes) {
        Compte loadeCompte = findByRib(rib, comptes);
        if (loadeCompte != null) {
            return -1;
        } else {
            Compte compte = new Compte();
            compte.setRib(rib);
            compte.setSolde(solde);
            if (compte.getSolde() < 100) {
                compte.setCategorie('C');
            } else if (compte.getSolde() < 1000) {
                compte.setCategorie('B');
            } else {
                compte.setCategorie('A');
            }
            comptes.add(compte);
            return 1;
        }
    }

    public Compte findByRib(String rib, List<Compte> comptes) {
        int index = findByIndex(rib, comptes);
        return index == -1 ? null : comptes.get(index);
    }

    public int debiter(String rib, double montant, List<Compte> comptes) {
        Compte compte = findByRib(rib, comptes);
        if (compte == null) {
            return -1;
        } else if (montant > compte.getSolde()) {
            return -2;
        } else {
            compte.setSolde(compte.getSolde() - montant);
            return 1;
        }
    }

    public int crediter(String rib, double montant, List<Compte> comptes) {
        Compte compte = findByRib(rib, comptes);
        if (compte == null) {
            return -1;
        } else {
            compte.setSolde(montant + compte.getSolde());
            return 1;
        }
    }

    public int transferer(String ribSource, String ribDestination, double montant, List<Compte> comptes) {
        Compte compteSource = findByRib(ribSource, comptes);
        Compte compteDestination = findByRib(ribSource, comptes);

        if (compteSource == null) {
            return -1;
        }
        if (compteDestination == null) {
            return -2;
        } else {
            int res = debiter(ribSource, montant, comptes);
            if (res > 0) {
                crediter(ribDestination, montant, comptes);
                return 1;
            } else {
                return -3;
            }
        }

    }

}
