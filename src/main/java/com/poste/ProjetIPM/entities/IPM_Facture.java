package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idfacture;
    private String matricule;
    private String code_acte;
    private Integer tarification;
    private Integer part_patient;
    private Integer part_ipm;
    private Double taux_ipm;
    private Date date_facture;
    private Date date_saisie;
    private String montant_facture;
    private String fileName;

    @OneToMany(mappedBy = "ipm_facture")
    private List<IPM_Bon> ipm_bons;
    @ManyToOne
    @JoinColumn(name = "code_prestataire")
    private IPM_Prestataire ipm_prestataire;
    @ManyToOne
    private IPM_Prestation ipm_prestation;
   private Integer numerofacture;
   @ManyToOne
   @JoinColumn(name = "id_employe")
     private IPM_Employe ipm_employe;
    @OneToMany(mappedBy = "ipm_facture")
    private List<IPM_Statut_Facture> ipm_statut_factures;
    @OneToMany(mappedBy = "ipm_facture")
    private List<IPM_Details_Facture> ipm_details_factures;
    public Long getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Long idfacture) {
        this.idfacture = idfacture;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCode_acte() {
        return code_acte;
    }

    public void setCode_acte(String code_acte) {
        this.code_acte = code_acte;
    }

    public Integer getTarification() {
        return tarification;
    }

    public void setTarification(Integer tarification) {
        this.tarification = tarification;
    }

    public Integer getPart_patient() {
        return part_patient;
    }

    public void setPart_patient(Integer part_patient) {
        this.part_patient = part_patient;
    }

    public Integer getPart_ipm() {
        return part_ipm;
    }

    public void setPart_ipm(Integer part_ipm) {
        this.part_ipm = part_ipm;
    }

    public Double getTaux_ipm() {
        return taux_ipm;
    }

    public void setTaux_ipm(Double taux_ipm) {
        this.taux_ipm = taux_ipm;
    }

    public Date getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Date date_facture) {
        this.date_facture = date_facture;
    }

    public Date getDate_saisie() {
        return date_saisie;
    }

    public void setDate_saisie(Date date_saisie) {
        this.date_saisie = date_saisie;
    }

    public String getMontant_facture() {
        return montant_facture;
    }

    public void setMontant_facture(String montant_facture) {
        this.montant_facture = montant_facture;
    }

    public List<IPM_Bon> getIpm_bons() {
        return ipm_bons;
    }

    public void setIpm_bons(List<IPM_Bon> ipm_bons) {
        this.ipm_bons = ipm_bons;
    }

   /* public IPM_Prestataire getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(IPM_Prestataire ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }*/

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public IPM_Prestataire getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(IPM_Prestataire ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }

    public IPM_Prestation getIpm_prestation() {
        return ipm_prestation;
    }

    public void setIpm_prestation(IPM_Prestation ipm_prestation) {
        this.ipm_prestation = ipm_prestation;
    }

  /*  public Long getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(Long ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }*/

    public List<IPM_Statut_Facture> getIpm_statut_factures() {
        return ipm_statut_factures;
    }

    public void setIpm_statut_factures(List<IPM_Statut_Facture> ipm_statut_factures) {
        this.ipm_statut_factures = ipm_statut_factures;
    }



    /*public IPM_Facture(Long idfacture, String matricule , Long ipm_prestataire, Date date_facture, String montant_facture, String fileName) {
        this.idfacture = idfacture;
        this.matricule = matricule;
        this.ipm_prestataire = ipm_prestataire;
        this.date_facture = date_facture;
        this.montant_facture = montant_facture;
        this.fileName = fileName;

    }*/
}
