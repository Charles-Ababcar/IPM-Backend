package com.poste.ProjetIPM.controllers;

import com.poste.ProjetIPM.keycloack.KeyCloakService;
import com.poste.ProjetIPM.entities.IPM_Remboursement;
import com.poste.ProjetIPM.entities.IPM_Role;
import com.poste.ProjetIPM.entities.IPM_UserRole;
import com.poste.ProjetIPM.services.IPM_RoleService;
import com.poste.ProjetIPM.services.IPM_RoleServiceImpl;
import com.poste.ProjetIPM.services.IPM_UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IPM_RoleController {

    @Autowired
    IPM_UserRoleServiceImpl ipm_userRoleService;
    @Autowired
    IPM_RoleServiceImpl ipm_roleService;

    @Autowired
    KeyCloakService keyCloakService;
    @GetMapping("/AllRole")
    public Collection<IPM_UserRole> getAllRole() {
        return ipm_userRoleService.getAllUserRole();
    }
    @GetMapping("/AllRoles")
    public Collection<IPM_Role> getRole() {
        return ipm_roleService.getAll();
    }
    /**
     * Affectation d'un role
     * userRole
     */
    @PostMapping(value = "/roleaddUser")
    public void affectRoleToUser(@RequestBody IPM_UserRole ipm_userRole){
        String username = ipm_userRole.getIpm_utilisateur().getEmail();
        String roleName = ipm_userRole.getIpm_role().getTypeRole();
        try{
            keyCloakService.addRealmRoleToUser(username, roleName);
            ipm_userRoleService.saveUserRole(ipm_userRole);
        } catch (Exception e){
            e.getCause();
            e.getMessage();
        }
    }

    @PostMapping(value = "/affectGroupRoleToUser")
    public void affectGroupRoleToUser(@RequestBody List<IPM_UserRole> userRoles){
        ipm_userRoleService.affectGroupRoleToUser(userRoles);
    }

    @DeleteMapping(value ="/deleteUser")
    public void deleteRoleFromUser(@RequestBody IPM_UserRole userRole){
        String username = userRole.getIpm_utilisateur().getEmail();
        String roleName = userRole.getIpm_role().getTypeRole();
        try{
            keyCloakService.removeRealmRoleToUser(username, roleName);
            ipm_userRoleService.deleteUserRole(userRole);
        }  catch(Exception e){
            e.getCause();
            e.getMessage();
        }
    }

    @PatchMapping(value ="deleteGroupRoleToUser")
    public void  deleteGroupRoleToUser(@RequestBody List<IPM_UserRole> userRoles){
        ipm_userRoleService.deleteGroupRoleToUser(userRoles);
    }
}
