package com.poste.ProjetIPM.Repository;

import com.poste.ProjetIPM.entities.IPM_Precompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IPM_PrecompteRepository extends JpaRepository<IPM_Precompte, Long> {
    List<IPM_Precompte> findByDatePrecompte(Date date);
}
