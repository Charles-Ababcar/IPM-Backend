package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_EnfantRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.services.IPM_EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_EnfantController {
    @Autowired
    IPM_EnfantService ipm_enfantService;
    @Autowired
    IPM_EnfantRepository ipm_enfantRepo;

    @GetMapping("/enfant")
    public Collection<IPM_Enfant> getAll() {
        return ipm_enfantService.getAll();
    }

    @GetMapping("/enfant/{id}")
    public IPM_Enfant getById(@PathVariable Long id) {
        return ipm_enfantService.getById(id);
    }

    @GetMapping(value = "/getenfantByid/{id}")
    public List<IPM_Enfant> getEnfantById(@PathVariable Long id) {
        return ipm_enfantRepo.getEnfantById(id);

    }
    @PostMapping("/enfant")
    public void save(@RequestBody IPM_Enfant ipm_enfant) {
        String uploadDir = "E:/Mes Dossiers/Images-IPM_Enfants/";
        ipm_enfant.setChemin(uploadDir+"/"+ipm_enfant.getChemin());
        ipm_enfantService.save(ipm_enfant);
    }

    @PutMapping("/enfant")
    public void update(@RequestBody IPM_Enfant ipm_enfant) {
        ipm_enfantService.update(ipm_enfant);
    }

    @DeleteMapping("/enfant/{id}")
    public void delete(@PathVariable Long id) {
        ipm_enfantService.delete(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@ModelAttribute IPM_Enfant ipm_enfant, @RequestParam("image") MultipartFile file)
            throws IOException {
        // IPM_Enfant e = ipm_enfantRepo.getEnfantById(id).get() ;
        ipm_enfantService.AjouterUnFichier( file);
        return "succes";
    }

    @GetMapping(path = "/ImagesEmp/{id}")
    public byte[] getPhoto(@PathVariable Long id) throws Exception {
        String uploadDir = "E:/Mes Dossiers/Images-IPM_Enfants/";
        IPM_Enfant ipm_enfant = ipm_enfantService.getById(id);
        System.out.println("message");
        byte[] bytes = Files.readAllBytes(get(uploadDir + "" + ipm_enfant.getChemin()));
        System.out.println(new String(bytes));
        return bytes;


    }
   /*@RequestMapping(value = "/Image/{id:.+}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        byte[] image = ipm_enfantService.getChemin(id);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }*/
}
