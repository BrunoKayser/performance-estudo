package com.geracao.relatorio.performance.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class AdressCompany {

    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String street;

}
