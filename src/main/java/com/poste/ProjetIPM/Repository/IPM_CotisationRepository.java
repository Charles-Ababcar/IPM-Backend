package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPM_CotisationRepository extends JpaRepository<IPM_Cotisation, Long> {
    IPM_Cotisation findByFileName(String fileName);
}
