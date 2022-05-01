package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VocRepository extends JpaRepository<VocEntity, Long> {

    Optional<VocEntity> findByPenaltyEntityId(Long id);
}
