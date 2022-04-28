package com.voc.voc.domain;


import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Carrier {

    CarrierId id;
    String name;
    String company;


    public CarrierEntity toEntity(){
        return CarrierEntity.builder()
                .name(this.name)
                .company(this.company)
                .build();
    }

    public Carrier(CarrierEntity carrierEntity){
        this.id = new CarrierId(carrierEntity.getId());
        this.name = carrierEntity.getName();
        this.company = carrierEntity.getCompany();
    }

    @AllArgsConstructor
    public static class CarrierId{
        Long id;
    }
}
