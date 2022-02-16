package com.poste.ProjetIPM;

import com.poste.ProjetIPM.Repository.IPM_UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetIpmApplicationTests {

    @Autowired
    private IPM_UtilisateurRepository utilisateurRepository;

    @Test
    public void testCreateUtilisateur() {

    }

}
