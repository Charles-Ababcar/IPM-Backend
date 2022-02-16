package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    /*@OneToMany(mappedBy = "ipm_cotisation")
    private List<IPM_Categorie> ipm_categories;*/
}
