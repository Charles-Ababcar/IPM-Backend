package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Details_Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDedtailsFacture;
    @ManyToOne
    @JoinColumn( name="idfacture", nullable=false)
    private IPM_Facture ipm_facture;
}
