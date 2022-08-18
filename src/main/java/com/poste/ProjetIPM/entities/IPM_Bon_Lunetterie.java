package com.poste.ProjetIPM.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

//@EqualsAndHashCode(callSuper = true)
 @EqualsAndHashCode(callSuper = true)
 @Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorValue("VCUST")
@PrimaryKeyJoinColumn(name="idbon")
//@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Lunetterie extends IPM_Bon {
    private String motif;
    private String ordonnance;
    private String numeroBon;
}
