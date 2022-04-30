package com.voc.voc.domain;


import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Carrier {

    CarrierId carrierId;
    String name;
    String company;

    public Carrier(CarrierEntity carrierEntity){
        this.carrierId = new CarrierId(carrierEntity.getId());
        this.name = carrierEntity.getName();
        this.company = carrierEntity.getCompany();
    }

    @AllArgsConstructor
    @Getter
    public static class CarrierId{
        Long id;
    }
}
