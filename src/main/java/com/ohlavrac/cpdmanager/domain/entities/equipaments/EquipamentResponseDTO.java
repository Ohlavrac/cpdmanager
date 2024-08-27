package com.ohlavrac.cpdmanager.domain.entities.equipaments;

import java.util.Date;
import java.util.UUID;

import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;

public record EquipamentResponseDTO(
    UUID id,
    String name,
    String description,
    String issue,
    EquipamentTypeEnum equipamenttype,
    StatusEnum status,
    Date created_at,
    Date updated_at
) {

}
