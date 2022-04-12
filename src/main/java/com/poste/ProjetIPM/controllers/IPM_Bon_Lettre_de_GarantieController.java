package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_Bon_Lettre_de_GarantieRepository;
import com.poste.ProjetIPM.entities.IPM_Bon_Lettre_de_Garantie;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.services.IPM_Bon_Lettre_de_GarantieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Bon_Lettre_de_GarantieController {

    @Autowired
    IPM_Bon_Lettre_de_GarantieService ipm_bon_lettre_de_garantieService;

    @PostMapping(path="/bonlettre")
    public void save(@RequestBody IPM_Bon_Lettre_de_Garantie ipm_bon_lettre_de_garantie) {
       ipm_bon_lettre_de_garantieService.save(ipm_bon_lettre_de_garantie);
    }

    @GetMapping("/bonlettre/{id}")
    public void getById(@PathVariable Long id) {
       ipm_bon_lettre_de_garantieService.getById(id);
    }
}
