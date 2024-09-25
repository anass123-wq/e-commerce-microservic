package com.spring.facture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
public class LigneFactureKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4722352116317893282L;


    @Column(name="facture_id")
    private Integer factureId;

    @Column(name="produit_id")
    private Integer produitId;
}
