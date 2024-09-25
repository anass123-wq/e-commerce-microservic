package com.spring.facture.repository.dao;

import com.spring.facture.PrendreApi.Client;
import com.spring.facture.PrendreApi.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "Produit/a")
public interface ProduitDao {
    @GetMapping("/Produit/Produits/findByRef/{ref}")
    Produit findByRef(@RequestParam("ref") String ref);

}



    // Define the endpoint to fetch the facture by name
