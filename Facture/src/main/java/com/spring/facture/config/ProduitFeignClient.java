package com.spring.facture.config;

import com.spring.facture.PrendreApi.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "produit")
public interface ProduitFeignClient {

    @GetMapping("/produits/{id}")
    Produit getProduitById(@PathVariable Integer id);

    @PutMapping("/produits/{id}/decrease")
    void decreaseQuantity(@PathVariable Integer id, @RequestParam double quantity);  // تقليل الكمية
}

