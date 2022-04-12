package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.services.IPM_FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_FactrureController {
    @Autowired
    IPM_FactureService ipm_factureService;

    @GetMapping("/allfacture")
    public Collection<IPM_Facture> getAll()
    {
        return ipm_factureService.getAll();
    }

    @GetMapping("/getfacture/{id}")
    public IPM_Facture getById(@PathVariable Long id) {
        return ipm_factureService.getById(id);
    }

    @PostMapping("/facture")
    public void save(@RequestBody IPM_Facture ipm_facture) {
        ipm_factureService.save(ipm_facture);
    }

    @PutMapping("/updatefacture")
    public void update(@RequestBody IPM_Facture ipm_facture) {
        ipm_factureService.update(ipm_facture);
    }

    @DeleteMapping("/facture/{id}")
    public void delete(@PathVariable Long id) {
        ipm_factureService.delete(id);
    }
}
