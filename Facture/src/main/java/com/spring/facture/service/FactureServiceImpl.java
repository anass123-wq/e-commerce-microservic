package com.spring.facture.service;

import com.spring.facture.model.Facture;
import com.spring.facture.repository.FactureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureRepository factureDao;

    @Override
    public Facture save(Facture factureEntity) {
        return factureDao.save(factureEntity);
    }

    @Override
    public List<Facture> findAll() {
        return factureDao.findAll();
    }
}