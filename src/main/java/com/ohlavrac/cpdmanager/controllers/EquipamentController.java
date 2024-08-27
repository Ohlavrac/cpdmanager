package com.ohlavrac.cpdmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentRequestDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentResponseDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.services.EquipamentService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/equipament")
public class EquipamentController {

    @Autowired
    private EquipamentService equipamentService;

    @PostMapping
    public ResponseEntity<EquipamentsEntity> create(@RequestBody EquipamentsEntity equipament) {
        EquipamentRequestDTO equipamentRequestDTO = new EquipamentRequestDTO(equipament.getName(), equipament.getDescription(), equipament.getIssue(), equipament.getEquipamenttype(), equipament.getStatus(), equipament.getCreated_at(), equipament.getUpdated_at());

        EquipamentsEntity newEquipament = this.equipamentService.createEquipament(equipamentRequestDTO);
        return ResponseEntity.ok(newEquipament);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EquipamentResponseDTO>> getAllEquipaments () {
        return ResponseEntity.ok(this.equipamentService.getAllEquipaments());
    }
    
}
