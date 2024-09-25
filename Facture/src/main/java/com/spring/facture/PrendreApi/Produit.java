package com.spring.facture.PrendreApi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.hc.core5.annotation.Contract;

import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Produit implements IsEmpty {

    @Id()
    @GeneratedValue
    private Integer id;

    private String libelle;

    private String ref;

    private float prix;

    private double quantiteStock;

    public Produit get2() {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return libelle.isEmpty();
    }

    public Produit getTo() {
        return this;
    }

}