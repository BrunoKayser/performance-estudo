package com.geracao.relatorio.performance.domain.enums;

import com.geracao.relatorio.performance.exception.EnumException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static io.micrometer.common.util.StringUtils.isEmpty;

@Getter
@AllArgsConstructor
public enum CompanySizeEnum {

    INVALID_SIZE("0"),
    TINY("1"),
    SMALL("2"),
    MODERATE("3"),
    AVERAGE("4"),
    LARGE("5"),
    VERY_LARGE("6"),
    HUGE("7");


    private final String value;

    public static CompanySizeEnum getByValue(String value) {
        for(CompanySizeEnum companySizeEnum: CompanySizeEnum.values()) {
            if (companySizeEnum.value.equals(value)) {
               return companySizeEnum;
            } else if(isEmpty(value)) {
                return INVALID_SIZE;
            }
        }
        throw new EnumException(String.format("Não existe enum para este valor %s", value));
    }

}
