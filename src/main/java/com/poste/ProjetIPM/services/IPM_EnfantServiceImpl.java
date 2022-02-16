package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.Repository.IPM_EnfantRepository;
import com.poste.ProjetIPM.entities.IPM_Employe;
import com.poste.ProjetIPM.entities.IPM_Enfant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Service
public class IPM_EnfantServiceImpl implements IPM_EnfantService {
    @Autowired
    IPM_EnfantRepository ipm_enfantRepository;

    @Override
    public Collection<IPM_Enfant> getAll() {
        return ipm_enfantRepository.findAll();
    }

    @Override
    public IPM_Enfant getById(long id) {
        return ipm_enfantRepository.findById(id).get();
    }

    @Override
    public List<IPM_Enfant> getEnfantById(Long id) {
        return ipm_enfantRepository.getEnfantById(id);
    }

    @Override
    public IPM_Enfant save(IPM_Enfant ipm_enfant) {
        return ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public void update(IPM_Enfant ipm_enfant) {
        ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public void delete(long id) {
        ipm_enfantRepository.deleteById(id);
    }

    @Override
    public IPM_Enfant AjouterUnFichier(long id, MultipartFile file) throws IOException {
        String uploadDir = "src/main/resources/static/images/";
        File fileName = new File(uploadDir + "" + file.getOriginalFilename());
        fileName.createNewFile();

        IPM_Enfant ipm_enfant = ipm_enfantRepository.findById(id).get();
        ipm_enfant.setIdenf(id);
        ipm_enfant.setChemin(uploadDir + "" + file.getOriginalFilename());
        ipm_enfantRepository.save(ipm_enfant);

        try (FileOutputStream fout = new FileOutputStream(fileName)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        return ipm_enfant;
    }


    @Override
    public IPM_Enfant AjouterLesAttributsDuFichier(IPM_Enfant ipm_enfant) {
        return ipm_enfantRepository.save(ipm_enfant);
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) {
        return (ResponseEntity<byte[]>) ipm_enfantRepository.getEnfantById(id);
    }
}
