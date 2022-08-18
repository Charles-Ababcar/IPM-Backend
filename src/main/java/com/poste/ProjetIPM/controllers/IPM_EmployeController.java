package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.Repository.IPM_EnfantRepository;
import com.poste.ProjetIPM.Repository.IPM_ServiceRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;

import java.io.File;
import java.io.IOException;

import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.entities.IPM_Service;
import com.poste.ProjetIPM.services.IPM_EmployeService;
import com.poste.ProjetIPM.services.IPM_ServiceService;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ContentType;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
/*@RequestMapping(path = "image")*/
//@RequestMapping("/api")
public class IPM_EmployeController {
    private byte[] bytes;
    @Autowired
    IPM_EmployeService ipm_employeService;
    @Autowired
    IPM_EmployeRepository ipm_employeRepository;
    @Autowired
    IPM_ServiceService ipm_serviceService;

    @GetMapping("/employe")
    public Collection<IPM_Employe> getAll() {
        return ipm_employeService.getAll();
    }

    @GetMapping("/employes/{id}")
    public IPM_Employe getById(@PathVariable Long id) {
        IPM_Employe ipm_employe=ipm_employeService.getById(id);
        ipm_employe.setPhoto(convertStringToBase64(ipm_employe.getPhoto()));

        return ipm_employe;

    }
    @GetMapping("/listemployes/{id}")
    public Collection<IPM_Employe> getListEmployeBysrvice(@PathVariable Long id){
        IPM_Service service=new IPM_Service();
        service=ipm_serviceService.getById(id);
        return ipm_employeService.getListbyservice(service);

    }
    ///ajouter photo
    @RequestMapping(path= "/uploads", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("image") MultipartFile file)
            throws IOException {
        ipm_employeService.AjouterUnFichierE(file);
        return "succes";
    }
    /*
    @PostMapping("/adddetailsfacture")
    public void updateLemploye(@RequestBody List<IPM_Employe> ipm_employe) {
//        IPM_Facture ipm_employe=ipm_factureService.getById(ipm_employe.getIpm_facture().getIdfacture());
//        ipm_details_facture.setIpm_facture(ipm_facture);
         ipm_employeService.save(ipm_employe);
        // return  ipm_details_facture;
    }
     */
    @PutMapping("/updateLEmploye")
    public void updateLemploye(@RequestBody List<IPM_Employe> ipm_employe) {
//        IPM_Facture ipm_employe=ipm_factureService.getById(ipm_employe.getIpm_facture().getIdfacture());
//        ipm_details_facture.setIpm_facture(ipm_facture);
        ipm_employeService.updateListe(ipm_employe);
        // return  ipm_details_facture;
    }

    @PostMapping("/employe")
    public void save(@RequestBody IPM_Employe ipm_employe) {
        String uploadDir = "C:/MesDossiers/Images-IPM_Employe/";
        ipm_employe.setPhoto(uploadDir+"/"+ipm_employe.getPhoto());
        Random random =new Random();
        ipm_employe.setNumero_carnet((long) (100+random.nextInt(100000)));

        ipm_employeService.save(ipm_employe);

    }
    @RequestMapping(path= "/uploadeJustif", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadJustif(@RequestParam("file") MultipartFile file)
            throws IOException {
        ipm_employeService.AjouterFichierJust(file);
        return "succes";
    }

    //function qui calcul de l'age a partir de la date de naissance

    ////fonction qui Conversion l'image en base 64
    public String convertStringToBase64(String fileName) {
        byte[] fileContent;
        if (fileName!=null) {
            try {
                File file = new File(fileName);
                if (file.exists()) {
                    fileContent = FileUtils.readFileToByteArray(file);
                    return "data:image/jpg;base64,"+ Base64.getEncoder().encodeToString(fileContent);
                } else
                    return "";
            } catch (IOException e) {
                return "Erreur de conversio";
            }
        }else{
            return "";
        }
    }

    @PutMapping("/employe")
    public void update(@RequestBody IPM_Employe ipm_employe) {
        ipm_employeService.update(ipm_employe);
    }

    @DeleteMapping("/employe/{id}")
    public void delete(@PathVariable Long id) {
        ipm_employeService.delete(id);
    }

    @GetMapping("/rechercheM/{A}/{B}")
    //String matricule="A"+"/"+"B";
    public IPM_Employe recherche_matricule(@PathVariable String A,@PathVariable String B) {
        return ipm_employeService.getByMatricule(A+"/"+B);
    }

    @GetMapping("/rechercheR/{reference}")
    public IPM_Employe recherche_reference(@PathVariable String reference) {
        return ipm_employeService.getByReference(reference);
    }
  @GetMapping("/getemploye/{matricule}")

   public IPM_Enfant getEmpl(@PathVariable  String matricule) {
      return ipm_employeRepository.getByMatricules(matricule);
 }
/////////////////Méthode de Calcul d'age///////////////////////////////
    public int getAge(int year, int month, int day) {
        Date now = new Date();
        int nowMonth = now.getMonth()+1;
        int nowYear = now.getYear()+1900;
        int result = nowYear - year;

        if (month > nowMonth) {
            result--;
        }
        else if (month == nowMonth) {
            int nowDay = now.getDate();

            if (day > nowDay) {
                result--;
            }
        }
        return result;
    }
}
