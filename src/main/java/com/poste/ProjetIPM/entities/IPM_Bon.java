package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class IPM_Bon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idbon;
    //private String matricule_emp;
    //private String numero_carte;
    private String malade;
    private String service;
    // private Integer quantite;
    // private String designation;
    //private String prix_unitaire;
    private String total;
    private Date date_etablissement;
    private Long nombre_article;

    public Long getNombre_article() {
        return nombre_article;
    }

    public void setNombre_article(Long nombre_article) {
        this.nombre_article = nombre_article;
    }

    @ManyToOne
    private IPM_Facture ipm_facture;

   /* @ManyToOne
    @JoinColumn(name = "ipm_bon")
    private IPM_Beneficiaire ipm_beneficiaire;*/

    @ManyToOne
    private IPM_Employe ipm_employe;

    @ManyToOne
    private IPM_Prestataire ipm_prestataire;

    @OneToMany(mappedBy = "ipm_bon")
    private List<IPM_Statut_Bon> ipm_statut_bons;

    public Long getIdbon() {
        return idbon;
    }

    public void setIdbon(Long idbon) {
        this.idbon = idbon;
    }

    public String getMalade() {
        return malade;
    }

    public void setMalade(String malade) {
        this.malade = malade;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Date getDate_etablissement() {
        return date_etablissement;
    }

    public void setDate_etablissement(Date date_etablissement) {
        this.date_etablissement = date_etablissement;
    }

    public IPM_Facture getIpm_facture() {
        return ipm_facture;
    }

    public void setIpm_facture(IPM_Facture ipm_facture) {
        this.ipm_facture = ipm_facture;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }

    public IPM_Prestataire getIpm_prestataire() {
        return ipm_prestataire;
    }

    public void setIpm_prestataire(IPM_Prestataire ipm_prestataire) {
        this.ipm_prestataire = ipm_prestataire;
    }

    public List<IPM_Statut_Bon> getIpm_statut_bons() {
        return ipm_statut_bons;
    }

    public void setIpm_statut_bons(List<IPM_Statut_Bon> ipm_statut_bons) {
        this.ipm_statut_bons = ipm_statut_bons;
    }
}
