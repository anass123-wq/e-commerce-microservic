package com.spring.facture.service;

import com.spring.facture.model.LigneFactureEntity;
import com.spring.facture.repository.LigneFactureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LigneFactureServiceImpl implements LigneFactureService {
    private final LigneFactureDao ligneFactureDao;

    @Override
    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
        return ligneFactureDao.save(ligneFactureEntity);
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }
}