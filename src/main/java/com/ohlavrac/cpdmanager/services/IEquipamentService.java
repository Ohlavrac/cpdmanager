package com.ohlavrac.cpdmanager.services;

import java.util.List;
import java.util.UUID;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentRequestDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentResponseDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;

public interface IEquipamentService {
    EquipamentsEntity createEquipament(EquipamentRequestDTO data);
    List<EquipamentResponseDTO> getAllEquipaments();
    EquipamentResponseDTO getEquipamentById(UUID equipamentID);
    Void deleteEquipamentById(UUID equipamentID);
    List<EquipamentResponseDTO> findEquipamentByType (EquipamentTypeEnum equipamentType);
    List<EquipamentResponseDTO> findEquipamentByStatus (StatusEnum status);
}
