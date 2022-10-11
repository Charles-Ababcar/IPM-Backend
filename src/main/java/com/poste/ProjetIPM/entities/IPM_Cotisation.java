package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Cotisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCotisation;

    public Long getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(Long idCotisation) {
        this.idCotisation = idCotisation;
    }

    public String getCumul_cotisation() {
        return cumul_cotisation;
    }

    public void setCumul_cotisation(String cumul_cotisation) {
        this.cumul_cotisation = cumul_cotisation;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }

    private String cumul_cotisation;

    @ManyToOne
    private IPM_Employe ipm_employe;
    private String montant;
    private String matricule;
    private String fileName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date_cotisation;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public IPM_Cotisation(String matricule , String montant , String fileName,Date date_cotisation) {
        this.matricule = matricule;
        this.montant = montant;
        this.fileName = fileName;
        this.date_cotisation= date_cotisation;


    }
    /*@OneToMany(mappedBy = "ipm_cotisation")
    private List<IPM_Categorie> ipm_categories;*/
}
