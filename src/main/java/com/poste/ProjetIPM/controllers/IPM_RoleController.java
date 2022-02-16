package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.entities.IPM_Role;
import com.poste.ProjetIPM.services.IPM_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
public class IPM_RoleController {

    @Autowired
    IPM_RoleService ipm_roleService;

    @GetMapping("/role")
    public Collection<IPM_Role> getAll() {
        return ipm_roleService.getAll();
    }

    @GetMapping("/role/{id}")
    public IPM_Role getById(@PathVariable Long id) {
        return ipm_roleService.getById(id);
    }

    @PostMapping("/role")
    public void save(@RequestBody IPM_Role ipm_role) {
        ipm_roleService.save(ipm_role);
    }

    @PutMapping("/role")
    public void update(@RequestBody IPM_Role ipm_role) {
        ipm_roleService.update(ipm_role);
    }

    @DeleteMapping("/role/{id}")
    public void delete(@PathVariable Long id) {
        ipm_roleService.delete(id);
    }
}
