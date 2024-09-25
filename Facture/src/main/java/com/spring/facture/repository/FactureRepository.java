package com.spring.facture.repository;

import com.spring.facture.model.Facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
