package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.entities.IPM_Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPM_PrestationRepository extends JpaRepository<IPM_Prestation, Long> {

}
