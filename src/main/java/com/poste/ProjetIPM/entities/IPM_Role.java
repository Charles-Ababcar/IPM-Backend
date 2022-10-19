package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeRole;
    public Long getIdRole() {
        return id;
    }

    public void setIdRole(Long idRole) {
        this.id = idRole;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    public Collection<IPM_Utilisateur> getIpm_utilisateurs() {
        return ipm_utilisateurs;
    }

    public void setIpm_utilisateurs(List<IPM_Utilisateur> ipm_utilisateurs) {
        this.ipm_utilisateurs = ipm_utilisateurs;
    }


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_Roles_Associations",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Collection<IPM_Utilisateur> ipm_utilisateurs;
}
