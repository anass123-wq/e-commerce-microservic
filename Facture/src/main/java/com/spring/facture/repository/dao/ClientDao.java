package com.spring.facture.repository.dao;

import com.spring.facture.PrendreApi.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//@Component
// The name is the name of the Facture service registered with Eureka

@FeignClient(name = "Client/a")
public interface ClientDao {
    // Define the endpoint to fetch the facture by name
    @GetMapping("/Client/Clients/findByCin/{cin}")
    Client findByCin(@RequestParam("cin") String cin);
}
