package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String login;
    private String mot_passe;
    //private String fonction;

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_passe() {
        return mot_passe;
    }

    public void setMot_passe(String mot_passe) {
        this.mot_passe = mot_passe;
    }

    public IPM_Service getIpm_service() {
        return ipm_service;
    }

    public void setIpm_service(IPM_Service ipm_service) {
        this.ipm_service = ipm_service;
    }

    @ManyToOne
    private IPM_Service ipm_service;


}
