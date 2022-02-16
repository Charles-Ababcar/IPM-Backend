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
public class IPM_Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRemboursement;
    private String montantRemboursement;
    private Date dateRemboursement;

    @ManyToOne
    private IPM_Employe ipm_employe;

    public Long getIdRemboursement() {
        return idRemboursement;
    }

    public void setIdRemboursement(Long idRemboursement) {
        this.idRemboursement = idRemboursement;
    }

    public String getMontantRemboursement() {
        return montantRemboursement;
    }

    public void setMontantRemboursement(String montantRemboursement) {
        this.montantRemboursement = montantRemboursement;
    }

    public Date getDateRemboursement() {
        return dateRemboursement;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemboursement = dateRemboursement;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }
}
