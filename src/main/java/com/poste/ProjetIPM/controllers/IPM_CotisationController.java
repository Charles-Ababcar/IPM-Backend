package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Categorie;
import com.poste.ProjetIPM.entities.IPM_Cotisation;
import com.poste.ProjetIPM.services.IPM_CotisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_CotisationController {

    @Autowired
    IPM_CotisationService ipm_cotisationService;

    @GetMapping(value = "/cotisation")
    public Collection<IPM_Cotisation> getAll() {
        return ipm_cotisationService.getAll();
    }

    @GetMapping("/cotisation/{id}")
    public IPM_Cotisation getById(@PathVariable Long id) {
        return ipm_cotisationService.getById(id);
    }

    @PostMapping("/cotisation")
    public void save(@RequestBody IPM_Cotisation ipm_cotisation) {
        ipm_cotisationService.save(ipm_cotisation);
    }

    @PutMapping("/cotisation")
    public void update(@RequestBody IPM_Cotisation ipm_cotisation) {
        ipm_cotisationService.update(ipm_cotisation);
    }

    @DeleteMapping("/cotisation/{id}")
    public void delete(@PathVariable Long id) {
        ipm_cotisationService.delete(id);
    }
}
