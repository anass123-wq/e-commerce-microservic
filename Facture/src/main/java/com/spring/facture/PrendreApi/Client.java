package com.spring.facture.PrendreApi;

import com.spring.facture.model.Facture;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public class Client implements IsEmpty {


    @Id()
    @GeneratedValue
        private Integer id;
        private String cin;
        private String nom;
        private String prenom;
        private String telephone;

        @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Facture> factures;

        public Client get() {
            return this;
        }
        @Override
        public boolean isEmpty() {
            return this.factures.isEmpty();
        }
    }
