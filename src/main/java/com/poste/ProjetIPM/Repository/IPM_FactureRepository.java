package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPM_FactureRepository extends JpaRepository<IPM_Facture, Long> {

    IPM_Facture findByFileName(String fileName);
}

