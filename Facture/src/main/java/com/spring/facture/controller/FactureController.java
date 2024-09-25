package com.spring.facture.controller;

import com.spring.facture.PrendreApi.Client;
import com.spring.facture.PrendreApi.Produit;
import com.spring.facture.config.ProduitFeignClient;
import com.spring.facture.model.Facture;
import com.spring.facture.model.LigneFactureEntity;
import com.spring.facture.model.LigneFactureKey;
import com.spring.facture.repository.FactureRepository;
import com.spring.facture.repository.LigneFactureDao;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author yassineabidar on 26/1/2023
 */
@RestController
@RequestMapping("factures")
public class FactureController {
    @Autowired
    private ProduitFeignClient produitFeignClient;
    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private LigneFactureDao ligneFactureRepository;
    @PostMapping
    public ResponseEntity<Facture> createFacture(@RequestBody Client client, @RequestBody List<LigneFactureEntity> ligneFactureS) {
        // 1. إنشاء الفاتورة وربطها بالعميل
        Facture facture = new Facture();
        facture.setDate(new Date());
        facture.setClient(client);
        facture.setRef(UUID.randomUUID().toString());

        // 2. متغير لحفظ المجموع الكلي للفاتورة
        float totalFacture = 0.0f;
        // 3. معالجة كل خط من الفاتورة
        for (LigneFactureEntity ligneFactureEntity : ligneFactureS) {
            // 2. جلب المنتج المرتبط بخط الفاتورة
            Produit produit = produitFeignClient.getProduitById(ligneFactureEntity.getProduit().getId());
            // 3. التحقق من الكمية المتاحة
            if (produit.getQuantiteStock() < ligneFactureEntity.getQuantite()) {
                return ResponseEntity.badRequest().body(null); // كمية غير كافية
            }

            // تقليل كمية المنتج في service produit
            produitFeignClient.decreaseQuantity(produit.getId(), ligneFactureEntity.getQuantite());

            // حساب السعر لهذا السطر (سعر المنتج * الكمية المطلوبة)
            float totalLigne =  produit.getPrix() * (float) ligneFactureEntity.getQuantite();

            // إضافة السعر لهذا السطر إلى المجموع الكلي للفاتورة
            totalFacture += totalLigne;

            // ربط LigneFactureEntity بالفاتورة والمنتج
            ligneFactureEntity.setFacture(facture);
            ligneFactureEntity.setProduit(produit);

            // ربط المفتاح المركب
            LigneFactureKey id = new LigneFactureKey(facture.getId(), produit.getId());
            ligneFactureEntity.setId(id);
        }


        // 7. حفظ الفاتورة وخط الفاتورة

        facture.setTotal(totalFacture); // حساب المجموع الكلي
        /* float totalLigne = produits.stream().mapToTloat(Produit::getPrice).sum();
        facture.setTotal<<<<<<<<<<<<<(totalAmount);

        */
        facture.setLigneFactures(ligneFactureS);
        factureRepository.save(facture);
        ligneFactureRepository.saveAll(ligneFactureS);



        return ResponseEntity.ok(facture);
    }

}

