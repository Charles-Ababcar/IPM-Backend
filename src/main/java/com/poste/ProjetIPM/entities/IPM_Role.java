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
public class IPM_Role {

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    public List<IPM_Utilisateur> getIpm_utilisateurs() {
        return ipm_utilisateurs;
    }

    public void setIpm_utilisateurs(List<IPM_Utilisateur> ipm_utilisateurs) {
        this.ipm_utilisateurs = ipm_utilisateurs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String typeRole;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ipm_user_role",
            joinColumns = @JoinColumn(name = "iduser"),
            inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    private List<IPM_Utilisateur> ipm_utilisateurs;
}
