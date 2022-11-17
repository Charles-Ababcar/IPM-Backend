package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface IPM_Details_FactureRepository  extends JpaRepository<IPM_Details_Facture,Long> {
    IPM_Facture findByFileName(String fileName);

    List<IPM_Details_Facture> findByIpmFacture(IPM_Facture ipmFacture);
    List<IPM_Details_Facture> findByDateSaisieBetween(Date d1, Date d2);
    @Query(value = "SELECT new IPM_Details_Facture(c.dateSaisie,SUM(c.part_patient),SUM(c.part_ipm),SUM(c.montant_facture),c.ipm_employe,c.ipmFacture) from IPM_Details_Facture  c where c.dateSaisie BETWEEN :d1 and :d2 GROUP BY c.ipm_employe")
    Collection<IPM_Details_Facture> getDateCr(@Param("d1") Date d1 ,@Param("d2") Date d2);
    //Collection<IPM_Details_Facture> findByIpmfacture(IPM_Conjoint _Facture ipmfacture);
}

