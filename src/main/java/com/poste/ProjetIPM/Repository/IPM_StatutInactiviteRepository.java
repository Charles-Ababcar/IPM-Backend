package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_StatutEmploye;
import com.poste.ProjetIPM.entities.IPM_StatutInactivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IPM_StatutInactiviteRepository extends JpaRepository<IPM_StatutInactivite,Long> {
    Collection<IPM_StatutInactivite> findByIpmStatutEmploye(IPM_StatutEmploye ipmStatutEmploye);
}
