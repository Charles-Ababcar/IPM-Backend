package com.poste.ProjetIPM.services;

import com.poste.ProjetIPM.entities.IPM_Bon;
import com.poste.ProjetIPM.entities.IPM_Bon_Lunetterie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPM_Bon_LunetterieService {
    void save(IPM_Bon_Lunetterie ipm_bon_lunetterie);

    String AjouterUnFichier(MultipartFile file) throws IOException;

   // List<IPM_Bon> getBonLunette(Long id);

    List<IPM_Bon> getBonLunetteConj(Long id);

    List<IPM_Bon> getBonLunetteEnf(Long id);

    List<IPM_Bon> getBonLunetterie(Long id);
}
