package com.poste.ProjetIPM.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idbon")
public class IPM_Bon_Consultation extends IPM_Bon {


}
