package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Employe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idemp;
    private String nom;
    private String prenom;
    private String sexe;

    private String matricule;
    private String picByte;
    @Column(length = 1200)
    private String photo;
    @Column()
   private  Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public IPM_Entity getIpm_entity() {
        return ipm_entity;
    }

    public void setIpm_entity(IPM_Entity ipm_entity) {
        this.ipm_entity = ipm_entity;
    }

    public Long getIdemp() {
        return idemp;
    }

    public void setIdemp(Long idemp) {
        this.idemp = idemp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Long getNumero_carnet() {
        return numero_carnet;
    }

    public void setNumero_carnet(Long numero_carnet) {
        this.numero_carnet = numero_carnet;
    }

    public String getAdresse_domicile() {
        return adresse_domicile;
    }

    public void setAdresse_domicile(String adresse_domicile) {
        this.adresse_domicile = adresse_domicile;
    }

    public Date getDate_nais() {
        return date_nais;
    }

    public void setDate_nais(Date date_nais) {
        this.date_nais = date_nais;
    }

    public String getLieu_nais() {
        return lieu_nais;
    }

    public void setLieu_nais(String lieu_nais) {
        this.lieu_nais = lieu_nais;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDate_recrutement() {
        return date_recrutement;
    }

    public void setDate_recrutement(Date date_recrutement) {
        this.date_recrutement = date_recrutement;
    }

    public String getSituation_familial() {
        return situation_familial;
    }

    public void setSituation_familial(String situation_familial) {
        this.situation_familial = situation_familial;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public Date getDate_debut_suspension() {
        return date_debut_suspension;
    }

    public void setDate_debut_suspension(Date date_debut_suspension) {
        this.date_debut_suspension = date_debut_suspension;
    }

    public Date getDate_fin_suspension() {
        return date_fin_suspension;
    }

    public void setDate_fin_suspension(Date date_fin_suspension) {
        this.date_fin_suspension = date_fin_suspension;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCumul_charge() {
        return cumul_charge;
    }

    public void setCumul_charge(String cumul_charge) {
        this.cumul_charge = cumul_charge;
    }

    public String getNiveau_salarial() {
        return niveau_salarial;
    }

    public void setNiveau_salarial(String niveau_salarial) {
        this.niveau_salarial = niveau_salarial;
    }

    public List<IPM_Cotisation> getIpm_cotisations() {
        return ipm_cotisations;
    }

    public void setIpm_cotisations(List<IPM_Cotisation> ipm_cotisations) {
        this.ipm_cotisations = ipm_cotisations;
    }

    public List<IPM_Bon> getIpm_bons() {
        return ipm_bons;
    }

    public void setIpm_bons(List<IPM_Bon> ipm_bons) {
        this.ipm_bons = ipm_bons;
    }

    public IPM_Service getIpm_service() {
        return ipm_service;
    }

    public void setIpm_service(IPM_Service ipm_service) {
        this.ipm_service = ipm_service;
    }

    public List<IPM_Remboursement> getIpm_remboursements() {
        return ipm_remboursements;
    }

    public void setIpm_remboursements(List<IPM_Remboursement> ipm_remboursements) {
        this.ipm_remboursements = ipm_remboursements;
    }

    public List<IPM_Precompte> getIpm_precompte() {
        return ipm_precompte;
    }

    public void setIpm_precompte(List<IPM_Precompte> ipm_precompte) {
        this.ipm_precompte = ipm_precompte;
    }

    public IPM_Categorie getIpm_categorie() {
        return ipm_categorie;
    }

    public void setIpm_categorie(IPM_Categorie ipm_categorie) {
        this.ipm_categorie = ipm_categorie;
    }

    public List<IPM_Conjoint> getIpm_conjoints() {
        return ipm_conjoints;
    }

    public void setIpm_conjoints(List<IPM_Conjoint> ipm_conjoints) {
        this.ipm_conjoints = ipm_conjoints;
    }

    public List<IPM_Enfant> getIpm_enfants() {
        return ipm_enfants;
    }

    public void setIpm_enfants(List<IPM_Enfant> ipm_enfants) {
        this.ipm_enfants = ipm_enfants;
    }

    private Long numero_carnet;
    private String adresse_domicile;
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date_nais;
    private String lieu_nais;
    private String telephone;
    //  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date_recrutement;
    private String situation_familial;
    private String solde;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //  @Temporal(TemporalType.TIME)

    private Date date_debut_suspension;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // @Temporal(TemporalType.TIME)
    private Date date_fin_suspension;
    private String reference;
    private String cumul_charge;
    private String niveau_salarial;
     /*private Session session;
     private Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();

     public Long getLastId() {
         return lastId;
     }*/
    //@OneToMany (mappedBy = "ipm_employe")
    // private List<IPM_Beneficiaire> ipm_beneficiaires;

    @JsonIgnore
    @OneToMany(mappedBy = "idCotisation")
    private List<IPM_Cotisation> ipm_cotisations;

    @JsonIgnore
    @OneToMany(mappedBy = "ipm_employe")
    private List<IPM_Bon> ipm_bons;

    //@JsonIgnore
    // @ManyToOne
    @ManyToOne
    private IPM_Service ipm_service;

    @JsonIgnore
    @OneToMany(mappedBy = "ipm_employe")
    private List<IPM_Remboursement> ipm_remboursements;

    @JsonIgnore
    @OneToMany(mappedBy = "ipm_employe")
    private List<IPM_Precompte> ipm_precompte;

    //@JsonIgnore
    //  @ManyToOne
    @ManyToOne
    private IPM_Categorie ipm_categorie;

    @ManyToOne
    private IPM_Entity ipm_entity;


    @JsonIgnore
    @OneToMany(mappedBy = "ipm_employe")
    private List<IPM_Conjoint> ipm_conjoints;

    @JsonIgnore
    @OneToMany(mappedBy = "ipm_employe")
    private List<IPM_Enfant> ipm_enfants;

}
