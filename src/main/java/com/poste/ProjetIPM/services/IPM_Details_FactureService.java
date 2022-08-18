package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Facture;

import java.util.Collection;
import java.util.List;

public interface IPM_Details_FactureService {
    Collection<IPM_Details_Facture> getAll();

    IPM_Details_Facture getById(long id);

    /*
    @Override
    public  List<IPM_Employe> updateListe(List<IPM_Employe> ipm_employe) {
        for (int i = 0; i < ipm_employe.size(); i++) {
            ipm_employeRepository.save(ipm_employe.get(i));
            //ipm_employeRepository.update(ipm_employe.get(i));
        }
        return ipm_employe;
    }
     */
    List<IPM_Details_Facture> updateListe(List<IPM_Details_Facture> ipm_details_factures);

    List<IPM_Details_Facture> save(List<IPM_Details_Facture> ipm_details_facture);


   // Collection <IPM_Details_Facture> getDetailFact(Long num);

    //Collection <IPM_Details_Facture> getDetailFact(IPM_Facture ipm_facture);


    Collection <IPM_Details_Facture> getDetailFact(IPM_Facture ipmFacture);

    void update(IPM_Details_Facture ipm_details_facture);

}