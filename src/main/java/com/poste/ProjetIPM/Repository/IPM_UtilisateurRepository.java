package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPM_UtilisateurRepository extends JpaRepository<IPM_Utilisateur, Long> {

    //Utilisateur findByLogin(String login);
   /* Optional<IPM_Utilisateur> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);*/
}
