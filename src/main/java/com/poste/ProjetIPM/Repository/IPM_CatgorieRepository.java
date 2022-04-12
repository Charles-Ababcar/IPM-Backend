package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPM_CatgorieRepository extends JpaRepository<IPM_Categorie, Long> {
}
