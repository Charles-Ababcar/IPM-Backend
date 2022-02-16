package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Pharmaceutique;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.services.IPM_Bon_PharmaceutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_Bon_PharmaceutiqueController {

    @Autowired
    IPM_Bon_PharmaceutiqueService ipm_bon_pharmaceutiqueService;

    @PostMapping("/bonpharma")
    public void save(@RequestBody IPM_Bon_Pharmaceutique ipm_bon_pharmaceutique) {
        IPM_Employe ipm_employe = new IPM_Employe();
        ipm_bon_pharmaceutiqueService.save(ipm_bon_pharmaceutique);
    }

    @GetMapping("/bonpharma/{id}")
    public void getById(@PathVariable Long id) {
        ipm_bon_pharmaceutiqueService.getById(id);
    }


}













































