package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Lettre_de_Garantie extends IPM_Bon {

    private String categorie_hospitalisation;
    private String motif;
    private String ordonnance;
    private String numeroBon;
}
