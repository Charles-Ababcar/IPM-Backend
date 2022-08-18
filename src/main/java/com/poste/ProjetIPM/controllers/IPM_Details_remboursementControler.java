package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Details_remboursement;
import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.services.IPM_Details_remboursementService;

import org.springframework.beans.factory.annotation.Autowired;
import com.poste.ProjetIPM.services.IPM_RemboursementService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Details_remboursementControler {
    @Autowired
    IPM_RemboursementService remboursementService;
    @Autowired
    IPM_Details_remboursementService ipmDetailsRemboursementService;
    @GetMapping("/detailsremboursement")
    public Collection<IPM_Details_remboursement> getAll() {
        return ipmDetailsRemboursementService.getAll();
    }
    @PostMapping("/adddetailsremboursement")
    public void addDetail (@RequestBody List<IPM_Details_remboursement> ipmDetailsRemboursements) {
        ipmDetailsRemboursementService.save(ipmDetailsRemboursements);

    }
    @DeleteMapping("/deletDetailremboursement/{id}")
    public void delete (@PathVariable Long id){
        ipmDetailsRemboursementService.delete(id);

    }
    @GetMapping("/reboursement/{id}")
    public IPM_Details_remboursement getById(@PathVariable Long id){
        return ipmDetailsRemboursementService.getById(id);

    }

    @GetMapping("/Detailremboursement/{id}")
    public Collection<IPM_Details_remboursement> getDetailByremboursement(@PathVariable Long id) {
        new IPM_Remboursement();
        IPM_Remboursement remboursement;
        remboursement=remboursementService.getById(id);
        return ipmDetailsRemboursementService.getDetailrembourse(remboursement);

    }

    @PutMapping("/update")
    public void update(@RequestBody IPM_Details_remboursement ipmDetailsRemboursement){
        ipmDetailsRemboursementService.update(ipmDetailsRemboursement);
    }


}
