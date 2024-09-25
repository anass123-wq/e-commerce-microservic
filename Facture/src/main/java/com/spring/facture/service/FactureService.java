package com.spring.facture.service;

import com.spring.facture.model.Facture;

import java.util.List;

public interface FactureService  {
    Facture save(Facture factureEntity);

    List<Facture> findAll();
}


