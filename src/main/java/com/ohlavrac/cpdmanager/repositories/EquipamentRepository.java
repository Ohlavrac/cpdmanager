package com.ohlavrac.cpdmanager.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;

@Repository
public interface EquipamentRepository extends JpaRepository<EquipamentsEntity, UUID> {

}
