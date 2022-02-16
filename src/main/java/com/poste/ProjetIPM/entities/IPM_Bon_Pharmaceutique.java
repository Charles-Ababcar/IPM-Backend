package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Pharmaceutique extends IPM_Bon {

    private Integer quantite;
    private String designation;

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Integer prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

   /* public String getSuivant_ordonnance_docteur() {
        return suivant_ordonnance_docteur;
    }

    public void setSuivant_ordonnance_docteur(String suivant_ordonnance_docteur) {
        this.suivant_ordonnance_docteur = suivant_ordonnance_docteur;
    }*/

    private Integer prix_unitaire;
    /* private String suivant_ordonnance_docteur;*/
}
