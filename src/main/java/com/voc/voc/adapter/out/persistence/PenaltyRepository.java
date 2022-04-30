package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.PenaltyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenaltyRepository extends JpaRepository<PenaltyEntity,Long> {
}
