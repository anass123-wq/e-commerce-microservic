package com.spring.facture.config;

import com.spring.facture.PrendreApi.Client;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Client")
//@RibbonClient(name = "Produit")

public interface ProxyClient {
    @GetMapping("/Client/{}/{}")
    Client getClient(@PathVariable String prenom);

}
