package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.entities.IPM_Details_Cotisations;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPM_Details_CotisationsRepository extends JpaRepository<IPM_Details_Cotisations,Long> {
   // List<IPM_Details_Cotisations> findByIpmcotisation(IPM_Cotisation ipmCotisation);
}
