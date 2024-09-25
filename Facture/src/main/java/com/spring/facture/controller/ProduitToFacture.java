package com.spring.facture.controller;

import com.spring.facture.PrendreApi.Produit;
import com.spring.facture.config.ProxyProduit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/FactureWithProduit")
public class ProduitToFacture {
    ProxyProduit proxyproduit;
    @GetMapping("/Produits/{ref}/{prix}")
    public Produit FactureWithProduit(@PathVariable String ref, @PathVariable float prix){

        Produit produitResponse = proxyproduit.getProduit(ref, prix);
        produitResponse.setLibelle("No");
        produitResponse.setQuantiteStock(20);
        //Team team = new Team(teamResponse.getId(),teamResponse.getFrom(),teamResponse.getTo(),teamResponse.getMoneyTeam(),"NONE","50");
        return produitResponse;
    }
}
