package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class UserRoleId implements Serializable {
    private int ipm_utilisateur;
    private int ipm_role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return ipm_utilisateur == that.ipm_utilisateur &&
                ipm_role == that.ipm_role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipm_utilisateur, ipm_role);
    }

    public int getIpm_utilisateur() {
        return ipm_utilisateur;
    }

    public void setIpm_utilisateur(int ipm_utilisateur) {
        this.ipm_utilisateur = ipm_utilisateur;
    }

    public int getIpm_role() {
        return ipm_role;
    }

    public void setIpm_role(int ipm_role) {
        this.ipm_role = ipm_role;
    }
}
