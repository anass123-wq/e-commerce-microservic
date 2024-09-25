package com.spring.facture.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * @author yassineabidar on 26/1/2023
 */
@Getter
@Setter
public class LigneFactureDto {

    private String refProduit;
    private Integer quantite;
}
