package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Precompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPrecompte;

    public long getIdPrecompte() {
        return IdPrecompte;
    }

    public void setIdPrecompte(long idPrecompte) {
        IdPrecompte = idPrecompte;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }

    @ManyToOne
    private IPM_Employe ipm_employe;
}
