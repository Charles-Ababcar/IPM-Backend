package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Details_Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDedtailsFacture;
    private String matricule;
    private String code_acte;
    private Integer tarification;
    private Integer part_patient;
    private Integer part_ipm;
    private Double taux_ipm;
    private Date date_facture;
    private Date date_saisie;
    private String montant_facture;
    @ManyToOne
    @JoinColumn(name="idfacture", nullable=false)
    private IPM_Facture ipm_facture;
    @ManyToOne
    @JoinColumn(name="code_prestation", nullable=false)
    private IPM_Prestation ipm_prestation;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private IPM_Employe ipm_employe;
}
