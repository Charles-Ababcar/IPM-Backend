package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_ConjointRepository;
import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.entities.IPM_Conjoint;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.services.IPM_ConjointService;
import org.dom4j.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_ConjointController {

    @Autowired
    IPM_ConjointService ipm_conjointService;

    @Autowired
    private IPM_ConjointRepository ipm_conjointRepo;

    @Autowired
    IPM_ConjointRepository ipm_conjointRepository;

    @Autowired
    IPM_EmployeRepository ipm_employeRepository;

    @GetMapping(value = "/conjoint")
    public Collection<IPM_Conjoint> getAll() {
        return ipm_conjointService.getAll();

    }


    @GetMapping(value = "/getconjointByid/{id}")
    public List<IPM_Conjoint> getConjointById(@PathVariable Long id) {
        return ipm_conjointRepo.getConjointById(id);

    }

   /* @GetMapping("/conjoint/{id}")
    public IPM_Conjoint getById(@PathVariable Long id){
        return ipm_conjointService.getById(id);
    }*/

    @PostMapping("/conjoint")
    public String save(@RequestBody IPM_Conjoint ipm_conjoint) {
        //ipm_employe =ipm_conjoint.getIpm_employe();
        // ipm_conjoint.setIpm_employe(ipm_employeRepository.findById(ipm_employe.getIdemp()).get());
        ipm_conjointService.save(ipm_conjoint);
        return "Slt " + ipm_conjoint.getNom_conjoint() + "enregistrement reussi avec success";
    }

    @PutMapping("/conjoint")
    public void update(@RequestBody IPM_Conjoint ipm_conjoint) {

        ipm_conjointService.update(ipm_conjoint);

    }

    @DeleteMapping("/conjoint/{id}")
    public void delete(@PathVariable Long id) {
        ipm_conjointService.delete(id);
    }
}
