package com.geracao.relatorio.performance.service;

import com.geracao.relatorio.performance.domain.Company;
import com.geracao.relatorio.performance.exception.BadRequestException;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jakarta.websocket.EncodeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final BuildListCompanyService buildListCompanyService;
    private final SanitializeArchiveService sanitializeArchiveService;

    public List<Company> readCSV() {
        try {
            var reader = Files.newBufferedReader(Paths.get("G:\\Outros computadores\\Meu laptop\\Bruno\\Projetos\\Gerador de arquivo\\Dados\\companies.csv"));

            var csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            return buildListCompanyService.buildCompanies(csvReader.readAll());
            //CSVReader csvReader = new CSVReaderBuilder(reader).build();
        } catch (Exception e) {
            log.error("Erro ao ler o arquivo ", e);
            throw new BadRequestException("Arquivo com algum registro inválido");
        }

    }



}
