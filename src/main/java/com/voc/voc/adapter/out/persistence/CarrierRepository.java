package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrierRepository extends JpaRepository<CarrierEntity, Long> {
    Optional<CarrierEntity> findById(Long id);
}
