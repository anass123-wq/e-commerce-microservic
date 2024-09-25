package com.spring.facture.config;

import com.spring.facture.PrendreApi.Produit;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "Produit")
//@RibbonClient(name = "Produit")
public interface ProxyProduit{
    @GetMapping("/Produit/{ref}/{prix}")
    Produit getProduit(@PathVariable String ref, @PathVariable float prix);

}
/*
*/