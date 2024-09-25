package com.spring.facture.mapper;

import com.spring.facture.PrendreApi.Produit;
import com.spring.facture.dto.LigneFactureDto;
import com.spring.facture.model.LigneFactureEntity;
import com.spring.facture.repository.dao.ProduitDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LigneFactureMapper {

    private final ProduitDao produitDao;
    public LigneFactureEntity toEntity(LigneFactureDto ligneFactureDto) {
        LigneFactureEntity ligneFactureEntity = new LigneFactureEntity();
        ligneFactureEntity.setProduit(getProduct(ligneFactureDto.getRefProduit()));
        ligneFactureEntity.setQuantite(ligneFactureDto.getQuantite());
        return ligneFactureEntity;
    }

    public LigneFactureDto toDto(LigneFactureEntity ligneFactureEntity) {
        LigneFactureDto ligneFactureDto = new LigneFactureDto();
        ligneFactureDto.setRefProduit(ligneFactureEntity.getProduit().getRef());
        ligneFactureDto.setQuantite((int) ligneFactureEntity.getQuantite());
        return ligneFactureDto;
    }

    public List<LigneFactureEntity> toEntities(List<LigneFactureDto> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toEntity).toList();
    }

    public List<LigneFactureDto> toDto(List<LigneFactureEntity> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toDto).toList();
    }

    private Produit getProduct(String refProduit) {
        final var byRef = produitDao.findByRef(refProduit);
        if (byRef.isEmpty()) {
            throw new RuntimeException("product not found !!");
        }
        return byRef.getTo();
    }
}
