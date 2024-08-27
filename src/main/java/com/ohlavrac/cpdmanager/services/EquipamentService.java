package com.ohlavrac.cpdmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentRequestDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentResponseDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.repositories.EquipamentRepository;

@Service
public class EquipamentService {

    @Autowired
    private EquipamentRepository repository;

    public EquipamentsEntity createEquipament(EquipamentRequestDTO data) {
        EquipamentsEntity newEquipament = new EquipamentsEntity();


        newEquipament.setName(data.name());
        newEquipament.setDescription(data.description());
        newEquipament.setIssue(data.issue());
        newEquipament.setEquipamenttype(data.equipamenttype());
        newEquipament.setStatus(data.status());
        newEquipament.setCreated_at(data.created_at());
        newEquipament.setUpdated_at(data.updated_at());

        this.repository.save(newEquipament);
        
        return newEquipament;
    }

    public List<EquipamentResponseDTO> getAllEquipaments() {
        List<EquipamentsEntity> equipamentsEntity = this.repository.findAll();

        return equipamentsEntity.stream().map(equipament -> new EquipamentResponseDTO(equipament.getId(), equipament.getName(), equipament.getDescription(), equipament.getIssue(), equipament.getEquipamenttype(), equipament.getStatus(), equipament.getCreated_at(), equipament.getUpdated_at())).toList();
    }
}