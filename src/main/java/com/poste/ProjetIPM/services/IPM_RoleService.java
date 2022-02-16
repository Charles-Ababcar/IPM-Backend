package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.entities.IPM_Role;

import java.util.Collection;

public interface IPM_RoleService {

    Collection<IPM_Role> getAll();

    IPM_Role getById(long id);

    void save(IPM_Role ipm_role);

    void update(IPM_Role ipm_role);

    void delete(Long id);
}
