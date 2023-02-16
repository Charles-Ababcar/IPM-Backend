package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Statut_Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatutFacture;

    public Long getIdStatutFacture() {
        return idStatutFacture;
    }

    public void setIdStatutFacture(Long idStatutFacture) {
        this.idStatutFacture = idStatutFacture;
    }

    public String getStatutFacture() {
        return statutFacture;
    }

    public void setStatutFacture(String statutFacture) {
        this.statutFacture = statutFacture;
    }


    private String statutFacture;
    @JsonIgnore
    @OneToMany(mappedBy = "ipmStatutFacture")
    private List<IPM_Facture> ipmFactures;


//    @ManyToOne
//    private IPM_Facture ipm_facture;
}
