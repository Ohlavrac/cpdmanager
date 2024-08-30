package com.ohlavrac.cpdmanager.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentRequestDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentResponseDTO;
import com.ohlavrac.cpdmanager.domain.entities.equipaments.EquipamentsEntity;
import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.services.EquipamentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




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

    @GetMapping("/{equipamentID}")
    public ResponseEntity<EquipamentResponseDTO> getMethodName(@PathVariable UUID equipamentID) {
        return ResponseEntity.ok(this.equipamentService.getEquipamentById(equipamentID));
    }

    @DeleteMapping("/{equipamentID}")
    public ResponseEntity<Void> deleteEquipament(@PathVariable UUID equipamentID) {
        this.equipamentService.deleteEquipamentById(equipamentID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{equipamentType}")
    public ResponseEntity<List<EquipamentResponseDTO>> getMethodName(@PathVariable EquipamentTypeEnum equipamentType) {
        System.out.println(">>>>>>>>>>> "+ equipamentType);
        return ResponseEntity.ok(this.equipamentService.findEquipamentByType(equipamentType));
    }
    
}
