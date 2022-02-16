package com.poste.ProjetIPM.controllers;


import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Prestation;

import com.poste.ProjetIPM.services.IPM_PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_PrestataireController {
    @Autowired
    IPM_PrestataireService ipm_prestataireService;

    @GetMapping("/prestataire")
    public Collection<IPM_Prestataire> getAll() {
        return ipm_prestataireService.getAll();
    }

    @GetMapping("/prestataire/{id}")
    public IPM_Prestataire getById(@PathVariable Long id) {
        return ipm_prestataireService.getById(id);
    }

    @PostMapping("/prestataire")
    public void save(@RequestBody IPM_Prestataire ipm_prestataire) {
        ipm_prestataireService.save(ipm_prestataire);
    }

    @PutMapping("/prestataire")
    public void update(@RequestBody IPM_Prestataire ipm_prestataire) {
        ipm_prestataireService.update(ipm_prestataire);
    }

    @DeleteMapping("/prestataire/{id}")
    public void delete(@PathVariable Long id) {
        ipm_prestataireService.delete(id);
    }
}
