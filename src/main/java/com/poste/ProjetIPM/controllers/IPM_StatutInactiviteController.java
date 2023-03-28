package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.*;
import com.poste.ProjetIPM.services.IPM_StatutEmployeService;
import com.poste.ProjetIPM.services.IPM_StatutInactiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_StatutInactiviteController {
    @Autowired
    IPM_StatutInactiviteService ipmStatutInactiviteService;
    @Autowired
    IPM_StatutEmployeService ipmStatutEmployeService;
    @GetMapping("/statutInactif/{id}")
    public Collection<IPM_StatutInactivite> getStatut(@PathVariable Long id)
    {
        IPM_StatutEmploye ipmStatutEmploye=new IPM_StatutEmploye();
        ipmStatutEmploye=ipmStatutEmployeService.getById(id);
        return ipmStatutInactiviteService.getById(ipmStatutEmploye);

    }
}
