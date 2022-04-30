package com.voc.voc.domain;


import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * 운송사 도메인
 */
@Value
@Getter
@AllArgsConstructor
public class Carrier {

    Identity carrierId;
    String name;
    String company;

    public Carrier(CarrierEntity carrierEntity){
        this.carrierId = new Identity(carrierEntity.getId());
        this.name = carrierEntity.getName();
        this.company = carrierEntity.getCompany();
    }

}
