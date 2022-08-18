package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPM_Details_remboursementRepository extends JpaRepository<IPM_Details_remboursement, Long> {

    List<IPM_Details_remboursement> findByIpmRemboursement(IPM_Remboursement ipmRemboursement);
}
