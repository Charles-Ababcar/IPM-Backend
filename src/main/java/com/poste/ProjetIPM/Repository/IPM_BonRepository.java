package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface IPM_BonRepository extends JpaRepository<IPM_Bon, Long> {
    //Collection<IPM_Bon>findAll();
    @Query(value = "select b from  IPM_Bon b ,IPM_Employe e where b.ipm_employe.idemp=:id and b.ipm_employe.idemp=e.idemp")
    List<IPM_Bon> getEmpById(@Param("id") Long id);

    @Query(value = "select b from  IPM_Bon b ,IPM_Prestataire p where b.ipm_prestataire.code_prestataire=:id and b.ipm_prestataire.code_prestataire=p.code_prestataire")
    List<IPM_Bon> getPresById(@Param("id") Long id);
}
