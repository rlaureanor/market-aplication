package com.rlaureano.market.persistence.mapper;

import com.rlaureano.market.domain.Purchase;
import com.rlaureano.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompras",target = "purchaseId"),
            @Mapping(source = "fecha",target = "date"),
            @Mapping(source = "medioPago",target = "paymentMethod"),
            @Mapping(source = "comentario",target = "comment"),
            @Mapping(source = "estado",target = "state"),
            @Mapping(source = "idCliente",target = "clientId"),
            @Mapping(source = "productos",target = "items")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente",ignore = true)
    Compra toCompra(Purchase purchase);
}
