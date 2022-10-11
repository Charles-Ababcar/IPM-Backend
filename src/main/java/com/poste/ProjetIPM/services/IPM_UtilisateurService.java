package com.poste.ProjetIPM.services;



import com.poste.ProjetIPM.entities.IPM_Utilisateur;

import java.util.List;

public interface IPM_UtilisateurService {
    public IPM_Utilisateur findUserByEmail(String email);

    boolean userExist(int userId);

    IPM_Utilisateur findUserById(int userId);

    IPM_Utilisateur updateUser(IPM_Utilisateur user);

    List<IPM_Utilisateur> getUserByStructureId(int structureId);

}
