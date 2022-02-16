package com.poste.ProjetIPM.controllers;


import com.poste.ProjetIPM.entities.IPM_Precompte;

import com.poste.ProjetIPM.services.IPM_PrecompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_PrecompteController {
    @Autowired
    IPM_PrecompteService ipm_precompteService;

    @GetMapping("/precompte")
    public Collection<IPM_Precompte> getAll() {
        return ipm_precompteService.getAll();
    }

    @GetMapping("/precompte/{id}")
    public IPM_Precompte getById(@PathVariable Long id) {
        return ipm_precompteService.getById(id);
    }

    @PostMapping("/precompte")
    public void save(@RequestBody IPM_Precompte ipm_precompte) {
        ipm_precompteService.save(ipm_precompte);
    }

    @PutMapping("/precompte")
    public void update(@RequestBody IPM_Precompte ipm_precompte) {
        ipm_precompteService.update(ipm_precompte);
    }

    @DeleteMapping("/precompte/{id}")
    public void delete(@PathVariable Long id) {
        ipm_precompteService.delete(id);
    }


}
