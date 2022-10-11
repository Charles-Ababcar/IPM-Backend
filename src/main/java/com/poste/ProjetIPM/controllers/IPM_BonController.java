package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_BonRepository;
import com.poste.ProjetIPM.Repository.IPM_ConjointRepository;
import com.poste.ProjetIPM.entities.IPM_Bon;

import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.services.IPM_BonService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_BonController {

    @Autowired
    IPM_BonService ipm_bonService;
    @Autowired
    private IPM_BonRepository ipm_bonRepository;

    @GetMapping("/bon")
    public Collection<IPM_Bon> getAllBon() {
        return  ipm_bonService.getAll();
    }

    @GetMapping("/bon/{id}")
    public IPM_Bon getById(@PathVariable Long id) {
        return ipm_bonService.getById(id);
    }

    @GetMapping(value = "/getbonByid/{id}")
    public List<IPM_Bon> getBonById(@PathVariable Long id) {
        return ipm_bonRepository.getEmpById(id);
    }

    @GetMapping(value = "/getpresById/{id}")
    public List<IPM_Bon> getBonPres(@PathVariable Long id) {
        return ipm_bonRepository.getPresById(id);
    }

    @PostMapping("/bon")
    public void save(@RequestBody IPM_Bon ipm_bon) {
//        Date date = new Date();
//        ZoneId timeZone = ZoneId.systemDefault();
//        LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();
//        ipm_bon.setNumeroBon(getLocalDate.getMonthValue()+"" +getLocalDate.getYear()+ RandomString.make(3));

        ipm_bonService.save(ipm_bon);
    }

    @PutMapping("/bon")
    public void update(@RequestBody IPM_Bon ipm_bon) {
        ipm_bonService.update(ipm_bon);
    }

    @DeleteMapping("/bon/{id}")
    public void delete(@PathVariable Long id) {
        ipm_bonService.delete(id);
    }
}
