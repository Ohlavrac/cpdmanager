package com.ohlavrac.cpdmanager.domain.entities.equipaments;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;
import com.ohlavrac.cpdmanager.domain.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private EquipamentTypeEnum equipamenttype;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;
}
