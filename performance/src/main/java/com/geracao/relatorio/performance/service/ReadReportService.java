package com.geracao.relatorio.performance.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReadReportService {

    @Autowired
    FileService fileService;

    public void readFile() {

        var companiesList = fileService.readCSV();

    }

}
