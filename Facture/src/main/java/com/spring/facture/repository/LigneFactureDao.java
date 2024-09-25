package com.spring.facture.repository;

import com.spring.facture.model.LigneFactureEntity;
import com.spring.facture.model.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LigneFactureKey> {
}
