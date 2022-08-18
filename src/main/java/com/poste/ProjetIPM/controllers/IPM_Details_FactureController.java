package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Details_Facture;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;

import com.poste.ProjetIPM.entities.IPM_Facture;
import com.poste.ProjetIPM.services.IPM_Details_FactureService;
import com.poste.ProjetIPM.services.IPM_FactureService;
import com.poste.ProjetIPM.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_Details_FactureController {
    @Autowired
    UploadService uploadService;
    @Autowired
    IPM_FactureService ipm_factureService;
    @Autowired
    IPM_Details_FactureService ipm_details_factureService;
    @GetMapping("/detailsfactures")
    public Collection<IPM_Details_Facture> getAll() {
        return ipm_details_factureService.getAll();
    }
    @PostMapping("/adddetailsfacture")
    public void createDetailsFcature(@RequestBody List<IPM_Details_Facture> ipm_details_facture) {
//        IPM_Facture ipm_facture=ipm_factureService.getById(ipm_details_facture.getIpm_facture().getIdfacture());
//        ipm_details_facture.setIpm_facture(ipm_facture);
         ipm_details_factureService.save(ipm_details_facture);
        // return  ipm_details_facture;
    }

    @GetMapping("/detailsfact/{id}")
    public IPM_Details_Facture getById(@PathVariable Long id) {
        IPM_Details_Facture ipm_details_facture=ipm_details_factureService.getById(id);
        return ipm_details_facture;
    }
    @GetMapping("/detailsfacture/{id}")
    public Collection<IPM_Details_Facture> getDetailByfacture(@PathVariable Long id) {
        new IPM_Facture();
        IPM_Facture facture;
        facture=ipm_factureService.getById(id);
       return ipm_details_factureService.getDetailFact(facture);
    }

    @PutMapping("/updateList")
    public void update(@RequestBody List<IPM_Details_Facture> ipm_details_facture) {
        ipm_details_factureService.updateListe(ipm_details_facture);
    }

    //put
    @PutMapping("/updateDetail")
    public void update(@RequestBody IPM_Details_Facture ipm_details_facture){
        ipm_details_factureService.update(ipm_details_facture);

    }
    /////////////////TODO:Implementation upload file excel
    @PostMapping(value = "/fileupload")
    public void uploadFile(@ModelAttribute IPM_Details_Facture ipm_details_facture, RedirectAttributes redirectAttributes){
        boolean isFlag = uploadService.saveDataFromUploadFile(ipm_details_facture.getFile());
        if (isFlag){
            redirectAttributes.addFlashAttribute("successmessage", "File Upload successfull !");
        } else {
            redirectAttributes.addFlashAttribute("errormessage", "File Upload not done, Please try again !");
        }
    }
}
