package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_StatutInactivite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAllStatut;
    private String libelleStatut;
    private String motif;
    @ManyToOne
    @JoinColumn(nullable =false)
    private IPM_StatutEmploye ipmStatutEmploye;

}
