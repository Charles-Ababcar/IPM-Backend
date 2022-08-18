package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IPM_Details_FactureRepository  extends JpaRepository<IPM_Details_Facture,Long> {
    IPM_Facture findByFileName(String fileName);

    List <IPM_Details_Facture> findByIpmFacture(IPM_Facture ipmFacture);

    /*List <IPM_Details_Facture>findByIdfacture(Long num);

    Collection<IPM_Details_Facture> findByIpm_facture(IPM_Facture ipm_facture);*/

    //Collection<IPM_Details_Facture> findByIpmfacture(IPM_Facture ipmfacture);
}
