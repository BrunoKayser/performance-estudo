package com.geracao.relatorio.performance.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PositionsCsvEnum {

    COMPANY_ID(0),
    NAME(1),
    DESCRIPTION(2),
    COPMANY_SIZE(3),
    STATE(4),
    COUNTRY(5),
    CITY(6),
    ZIP_CODE(7),
    ADRESS(8),
    URL(9);

    private final int position;

}