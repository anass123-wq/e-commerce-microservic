package com.spring.facture.service;

import com.spring.facture.model.LigneFactureEntity;

import java.util.List;

public interface LigneFactureService {

    LigneFactureEntity save(LigneFactureEntity ligneFactureEntity);

    List<LigneFactureEntity> findAll();
}