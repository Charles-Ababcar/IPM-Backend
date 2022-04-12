package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPM_Bon_Lettre_de_GarantieRepository extends JpaRepository<IPM_Bon_Lettre_de_Garantie,Long> {
}
