package com.spring.facture.mapper;

import com.spring.facture.PrendreApi.Client;
import com.spring.facture.dto.FactureDto;
import com.spring.facture.model.Facture;
import com.spring.facture.repository.dao.ClientDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FactureMapper {

    private final ClientDao clientDao;
    private final LigneFactureMapper ligneFactureMapper;



    public FactureDto toDto(Facture factureEntity) {
        FactureDto factureDto = new FactureDto();
        factureDto.setRef(factureEntity.getRef());
        factureDto.setCin(factureEntity.getClient().getCin());
        factureDto.setLigneFactureDtoList(ligneFactureMapper.toDto(factureEntity.getLigneFactures()));
        return factureDto;
    }

    public Facture toEntity(FactureDto factureDto) {
        Facture factureEntity = new Facture();
        factureEntity.setRef(factureDto.getRef());
        factureEntity.setClient(getClient(factureDto.getCin()));
        factureEntity.setLigneFactures(ligneFactureMapper.toEntities(factureDto.getLigneFactureDtoList()));
        return factureEntity;

    }

    public List<FactureDto> toDto(List<Facture> facturesEntity) {
        return facturesEntity.stream().map(this::toDto).toList();
    }

    public List<Facture> toEntities(List<FactureDto> factureDtos) {
        return factureDtos.stream().map(this::toEntity).toList();
    }

    private Client getClient(String cin) {
        final var byCin = clientDao.findByCin(cin);
        if (byCin.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return byCin.get();
    }
}
