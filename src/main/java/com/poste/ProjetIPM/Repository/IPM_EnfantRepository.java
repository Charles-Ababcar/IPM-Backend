package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface IPM_EnfantRepository extends JpaRepository<IPM_Enfant, Long> {

    @Query(value = "select c from  IPM_Enfant c ,IPM_Employe e where c.ipm_employe.idemp=:id and c.ipm_employe.idemp=e.idemp")
    List<IPM_Enfant> getEnfantById(@Param("id") Long id);
    //Recuperer un l'enfant de chaque employé
    @Query(value = "select c from  IPM_Enfant c ,IPM_Employe e where c.ipm_employe.idemp=:id and c.ipm_employe.idemp=e.idemp")
    IPM_Enfant getEnfant(@Param("id") Long id);
    //Compter les enfants qui ont moins de 5ans
    @Query(value = "SELECT  *, DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),i.date_nais_enfant)), '%Y') AS age FROM ipm_enfant i having age<=5",nativeQuery = true)
     long countByAge();
    //Compter les enfants qui ont plus de  5ans
    @Query(value = "SELECT *, SELECT DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),i.date_nais_enfant)), '%Y')  AS age FROM ipm_enfant i having age>5;",nativeQuery = true)
    long countAgeSuperieur();
}
