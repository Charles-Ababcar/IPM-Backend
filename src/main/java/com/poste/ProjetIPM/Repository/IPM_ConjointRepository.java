package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPM_ConjointRepository extends JpaRepository<IPM_Conjoint, Long> {
    @Query(value = "select c from  IPM_Conjoint c ,IPM_Employe e where c.ipm_employe.idemp=:id and c.ipm_employe.idemp=e.idemp")
    List<IPM_Conjoint> getConjointById(@Param("id") Long id);
}
