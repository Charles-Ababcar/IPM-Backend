package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.Repository.IPM_RoleRepository;
import com.poste.ProjetIPM.entities.IPM_Prestataire;
import com.poste.ProjetIPM.entities.IPM_Utilisateur;
import com.poste.ProjetIPM.services.IPM_PrestataireService;
import com.poste.ProjetIPM.services.IPM_UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api")
public class IPM_UtilisateurController {
    /*  @Autowired
      UtilisateurRepository userRep;

      @RequestMapping(value = "/",method = RequestMethod.GET)
      public Utilisateur getUserByLogin(@PathVariable String login)
      {
          return userRep.findByLogin(login);
      }*/
/*  @Autowired
    AuthenticationManager authenticationManager;
  @Autowired
    IPM_RoleRepository ipm_roleRepository;
  @Autowired
    PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;*/
    @Autowired
    IPM_UtilisateurService ipm_utilisateurService;

    @GetMapping("/utilisateur")
    public Collection<IPM_Utilisateur> getAll() {
        return ipm_utilisateurService.getAll();
    }

    @GetMapping("/utilisateur/{id}")
    public IPM_Utilisateur getById(@PathVariable Long id) {
        return ipm_utilisateurService.getById(id);
    }

    @PostMapping("/utilisateur")
    public void save(@RequestBody IPM_Utilisateur ipm_utilisateur) {
        ipm_utilisateurService.save(ipm_utilisateur);
    }

    @PutMapping("/utilisateur")
    public void update(@RequestBody IPM_Utilisateur ipm_utilisateur) {
        ipm_utilisateurService.update(ipm_utilisateur);
    }

    @DeleteMapping("/utilisateur/{id}")
    public void delete(@PathVariable Long id) {
        ipm_utilisateurService.delete(id);
    }
}
