package com.poste.ProjetIPM.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poste.ProjetIPM.Repository.IPM_EmployeRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.poste.ProjetIPM.entities.IPM_Enfant;
import com.poste.ProjetIPM.services.IPM_EmployeService;
import com.poste.ProjetIPM.util.ImageUtility;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.poste.ProjetIPM.Domaine.Response;
import com.poste.ProjetIPM.ResourcesNotFound.ResourceNotFound;

@RestController
@CrossOrigin(origins = "*")
/*@RequestMapping(path = "image")*/
//@RequestMapping("/api")
public class IPM_EmployeController {
    private byte[] bytes;
    @Autowired
    IPM_EmployeService ipm_employeService;
    @Autowired
    private ServletContext context;
    @Autowired
    IPM_EmployeRepository ipm_employeRepository;

    @GetMapping("/employe")
    public Collection<IPM_Employe> getAll() {
        return ipm_employeService.getAll();
    }

    @GetMapping("/employe/{id}")
    public IPM_Employe getById(@PathVariable Long id) {
        return ipm_employeService.getById(id);

    }

    ///ajouter photo
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    /* @PostMapping("/employe")
     public void createEmploye(@RequestBody IPM_Employe ipm_employe)
     {
         ipm_employe.setPicByte(this.bytes);
         ipm_employeService.save(ipm_employe);
         this.bytes=null;
     }*/
/*@PostMapping("/employe/")
public ResponseEntity<Response> createEmploye (@RequestParam MultipartFile file,
                                             @RequestBody String ipm_employe)
        throws JsonParseException, JsonMappingException,Exception{
    System.out.println("ok ..............");
    IPM_Employe ipm_emp = new ObjectMapper().readValue(ipm_employe, IPM_Employe.class);
    boolean isExist = new File(context.getRealPath("/E:/Images/")).exists();
    if (!isExist) {
        new File(context.getRealPath("/E:/Images/")).mkdir();
        System.out.println("mk dir ......................");
    }
    String image = file.getOriginalFilename();
    String newFileName = FilenameUtils.getBaseName(image) + "." + FilenameUtils.getExtension(image);
    File serverFile = new File(context.getRealPath("/E:/Images/" + File.separator + newFileName));
    try {
        System.out.println("/E:/Images/");
        FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
    } catch (Exception e) {
        e.printStackTrace();
    }
    ipm_emp.setImage(newFileName);
    IPM_Employe ipm =ipm_employeService.save(ipm_emp);
    if(ipm !=null)
    {
        return  new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
    }
    else
    {
        return  new ResponseEntity<Response>(new Response("Employe not saved"),HttpStatus.BAD_REQUEST);
    }

}*/
    @GetMapping(path = "/ImagesEmployes/{id}")
    public byte[] getPhoto(@PathVariable Long id) throws Exception {
        IPM_Employe IPM_Employe = ipm_employeService.getById(id);
        System.out.println("message");
        final byte[] bytes = Files.readAllBytes(Paths.get(context.getRealPath("/E:/Images/") + IPM_Employe.getPicByte()));
        return bytes;
    }


    @PostMapping("/employe")
    public String save(@RequestBody IPM_Employe ipm_employe) {
        ipm_employe.setPicByte(this.bytes);
        ipm_employeService.save(ipm_employe);
        this.bytes = null;
        return "Slt " + ipm_employe.getNom() + "enregistrement reussi avec success";

    }

    @PutMapping("/employe")
    public void update(@RequestBody IPM_Employe ipm_employe) {
        ipm_employeService.update(ipm_employe);
    }

    @DeleteMapping("/employe/{id}")
    public void delete(@PathVariable Long id) {
        ipm_employeService.delete(id);
    }

    @GetMapping("/rechercheM/{matricule}")
    public IPM_Employe recherche_matricule(@PathVariable String matricule) {
        return ipm_employeService.getByMatricule(matricule);
    }

    @GetMapping("/rechercheR/{reference}")
    public IPM_Employe recherche_reference(@PathVariable String reference) {
        return ipm_employeService.getByReference(reference);
    }

}
