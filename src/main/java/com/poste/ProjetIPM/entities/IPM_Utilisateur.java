
package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
    private boolean isEnable;


    //@JsonIgnoreProperties("users")
    @ManyToMany
    @JoinTable( name = "Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "id_user" ),
            inverseJoinColumns = @JoinColumn( name = "id_role" ) )

    private Collection<IPM_Role> roles ;
   /* @ManyToOne
    private IPM_Service ipmService;*/


}

