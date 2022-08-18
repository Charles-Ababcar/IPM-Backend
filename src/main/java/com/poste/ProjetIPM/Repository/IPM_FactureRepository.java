package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface IPM_FactureRepository extends JpaRepository<IPM_Facture, Long> {
    List<IPM_Facture> findByCertifier(boolean certfier);
    List<IPM_Facture> findByDateFacture(Date date);
    IPM_Facture findByIdfacture(Long id);


   // void put(IPM_Facture ipm_facture);

//    IPM_Facture findByFileName(String fileName);
//  @Query(value = "select sum(DISTINCT f.montant_facture) from  IPM_Facture f ")
//  List<IPM_Facture> getMontantTotal(IPM_Facture ipm_facture);
}

