package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private String fileName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_facture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_saisie;
    private Integer montant_facture;

    @lombok.Getter
    @ManyToOne
    @JoinColumn(name="idfacture")
    private IPM_Facture ipmFacture;
    @ManyToOne
    @JoinColumn(name="code_prestation")
    private IPM_Prestation ipm_prestation;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private IPM_Employe ipm_employe;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public IPM_Details_Facture(String matricule , Integer montant_facture, Date date_facture, String fileName) {
        this.matricule = matricule;
        this.montant_facture = montant_facture;
        this.date_facture = date_facture;
        this.fileName = fileName;

    }
    public IPM_Details_Facture(String matricule ,Integer montant_factur, String fileName) {
        this.matricule = matricule;
        this.montant_facture = montant_facture;
        this.fileName = fileName;

    }
}
