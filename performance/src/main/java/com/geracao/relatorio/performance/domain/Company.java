package com.geracao.relatorio.performance.domain;

import com.geracao.relatorio.performance.domain.enums.CompanySizeEnum;
import com.geracao.relatorio.performance.utils.CSVCompanyUtils;
import lombok.*;

import java.util.List;
import java.util.function.Function;

@Builder
@Setter
@Getter
@ToString
public class Company {

    @Getter(AccessLevel.NONE)
    private final List<Function<String, Boolean>> INVALID_CLAUSULES_COMPANY = List.of(
            (noParameter) -> CompanySizeEnum.INVALID_SIZE.equals(this.companySize),
            (noParameter) -> CSVCompanyUtils.hasInvalidValue(this.adress.getCountry()),
            (noParameter) -> CSVCompanyUtils.hasInvalidValue(this.adress.getCity()),
            (noParameter) -> CSVCompanyUtils.hasInvalidValue(this.adress.getState()),
            (noParameter) -> CSVCompanyUtils.hasInvalidValue(this.adress.getZipCode()),
            (noParameter) -> CSVCompanyUtils.hasInvalidValue(this.adress.getStreet()));

    private Long companyId;
    private String name;
    private String description;
    private String url;
    private CompanySizeEnum companySize;
    private AdressCompany adress;

    public boolean isValidCompany() {
       return !INVALID_CLAUSULES_COMPANY
                .stream()
                .anyMatch(clausure -> clausure.apply("Not need parameter"));
    }

}
