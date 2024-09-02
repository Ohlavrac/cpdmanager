package com.ohlavrac.cpdmanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentRequestDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentResponseDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;
import com.ohlavrac.cpdmanager.exceptions.EquipamentNotFoundException;
import com.ohlavrac.cpdmanager.repositories.EquipamentRepository;

@Service
public class EquipamentService implements IEquipamentService{

    @Autowired
    private EquipamentRepository repository;

    @Override
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

    @Override
    public List<EquipamentResponseDTO> getAllEquipaments() {
        List<EquipamentsEntity> equipamentsEntity = this.repository.findAll();

        return equipamentsEntity.stream().map(equipament -> new EquipamentResponseDTO(equipament.getId(), equipament.getName(), equipament.getDescription(), equipament.getIssue(), equipament.getEquipamenttype(), equipament.getStatus(), equipament.getCreated_at(), equipament.getUpdated_at())).toList();
    }

    @Override
    public EquipamentResponseDTO getEquipamentById(UUID equipamentID) {
        EquipamentsEntity equipamentsEntity = this.repository.findById(equipamentID).orElseThrow(() -> new EquipamentNotFoundException("Equipament not found"));

        return new EquipamentResponseDTO(equipamentsEntity.getId(), equipamentsEntity.getName(), equipamentsEntity.getDescription(), equipamentsEntity.getIssue(), equipamentsEntity.getEquipamenttype(), equipamentsEntity.getStatus(), equipamentsEntity.getCreated_at(), equipamentsEntity.getUpdated_at());
    }

    @Override
    public Void deleteEquipamentById(UUID equipamentID) {
        this.repository.deleteById(equipamentID);

        return null;
    }

    @Override
    public List<EquipamentResponseDTO> findEquipamentByType(EquipamentTypeEnum equipamentType) {
        List<EquipamentsEntity> equipamentsEntities = this.repository.findEquipamentByType(equipamentType);

        if (equipamentsEntities.isEmpty()) {
            throw new EquipamentNotFoundException("Equipaments not fount with this Type: "+ equipamentType);
        }

        return equipamentsEntities.stream().map(equipament -> new EquipamentResponseDTO(equipament.getId(), equipament.getName(), equipament.getDescription(), equipament.getIssue(), equipament.getEquipamenttype(), equipament.getStatus(), equipament.getCreated_at(), equipament.getUpdated_at())).toList();
    }

    @Override
    public List<EquipamentResponseDTO> findEquipamentByStatus(StatusEnum status) {
        List<EquipamentsEntity> equipamentsEntities = this.repository.findEquipamentByStatus(status);

        if (equipamentsEntities.isEmpty()) {
            throw new EquipamentNotFoundException("Equipament not found with this Status: "+ status);
        }

        return equipamentsEntities.stream().map(equipament -> new EquipamentResponseDTO(equipament.getId(), equipament.getName(), equipament.getDescription(), equipament.getIssue(), equipament.getEquipamenttype(), equipament.getStatus(), equipament.getCreated_at(), equipament.getUpdated_at())).toList();
    }
}