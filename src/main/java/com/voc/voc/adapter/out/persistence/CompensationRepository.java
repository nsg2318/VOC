package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.CompensationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompensationRepository extends JpaRepository<CompensationEntity, Long> {
    List<CompensationEntity> findAll();
}
