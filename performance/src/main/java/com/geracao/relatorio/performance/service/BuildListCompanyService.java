package com.geracao.relatorio.performance.service;

import com.geracao.relatorio.performance.domain.AdressCompany;
import com.geracao.relatorio.performance.domain.Company;
import com.geracao.relatorio.performance.domain.enums.CompanySizeEnum;
import com.geracao.relatorio.performance.domain.enums.PositionsCsvEnum;
import com.geracao.relatorio.performance.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BuildListCompanyService {

    private static final int POSITION_IF_DOESNT_HAS_EXCEPTION = 1;

    public List<Company> buildCompanies(List<String[]> allCopmanyCsv) {
        var list = new ArrayList<Company>();

        for(String[] companyCsv : allCopmanyCsv) {
            try {
                var company = buildCompany(companyCsv);
                insertIfValidCompany(company, list);
            } catch(Exception e) {
                log.error("Erro ao montar a empresa {} na posição {}", companyCsv, list.size() + POSITION_IF_DOESNT_HAS_EXCEPTION, e);
                throw new BadRequestException(String.format("Registro %s contem informações inválids", companyCsv));
            }
        }
        return list;
    }

    private Company buildCompany(String[] companyCsv) {
        return Company
                .builder()
                .companyId(Long.valueOf(companyCsv[PositionsCsvEnum.COMPANY_ID.getPosition()]))
                .name(companyCsv[PositionsCsvEnum.NAME.getPosition()])
                .description(companyCsv[PositionsCsvEnum.DESCRIPTION.getPosition()])
                .url(companyCsv[PositionsCsvEnum.URL.getPosition()])
                .companySize(CompanySizeEnum.getByValue(companyCsv[PositionsCsvEnum.COPMANY_SIZE.getPosition()]))
                .adress(AdressCompany
                        .builder()
                        .country(companyCsv[PositionsCsvEnum.COUNTRY.getPosition()])
                        .city(companyCsv[PositionsCsvEnum.CITY.getPosition()])
                        .zipCode(companyCsv[PositionsCsvEnum.ZIP_CODE.getPosition()])
                        .state(companyCsv[PositionsCsvEnum.STATE.getPosition()])
                        .street(companyCsv[PositionsCsvEnum.ADRESS.getPosition()])
                        .build())
                .build();
    }

    private void insertIfValidCompany(Company company, ArrayList<Company> list) {
        if(company.isValidCompany()) {
            list.add(company);
        } else {
            log.warn("Esta empresa possui dados inválidos {}", company);
        }
    }

}
