package com.ohlavrac.cpdmanager.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;

@Repository
public interface EquipamentRepository extends JpaRepository<EquipamentsEntity, UUID> {

    @Query("SELECT e FROM EquipamentsEntity e WHERE e.equipamenttype=?1")
    List<EquipamentsEntity> findEquipamentByType(EquipamentTypeEnum equipamenttype);

    @Query("SELECT e FROM EquipamentsEntity e WHERE e.staus=?1")
    List<EquipamentsEntity> findEquipamentByStatus(StatusEnum status);
}
