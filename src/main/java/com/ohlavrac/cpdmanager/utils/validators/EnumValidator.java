package com.ohlavrac.cpdmanager.utils.validators;

import com.ohlavrac.cpdmanager.domain.enums.EquipamentTypeEnum;

public class EnumValidator {

    public EquipamentTypeEnum validateType(String type) {
        if (type == "COMPUTER" || type == "computer") {
            return EquipamentTypeEnum.COMPUTER;
        } else if (type == "PCPART" || type == "pcpart") {
            return EquipamentTypeEnum.PCPART;
        } else if (type == "CABLE" || type == "cable") {
            return EquipamentTypeEnum.CABLE;
        } else if (type == "PRINTER" || type == "printer") {
            return EquipamentTypeEnum.PRINTER;
        } else {
            return EquipamentTypeEnum.UNDEFINED;
        }
    }
}
