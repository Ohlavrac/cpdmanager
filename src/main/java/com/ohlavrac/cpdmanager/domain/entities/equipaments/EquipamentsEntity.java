package com.ohlavrac.cpdmanager.domain.entities.equipaments;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "equipaments")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentsEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private String issue;

    private EquipamentTypeEnum equipamenttype;
    private StatusEnum status;

    @CreatedDate
    private Date created_at;

    @LastModifiedDate
    private Date updated_at;
}
