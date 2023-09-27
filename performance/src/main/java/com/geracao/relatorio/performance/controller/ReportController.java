package com.geracao.relatorio.performance.controller;

import com.geracao.relatorio.performance.service.ReadReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/report/read")
public class ReportController {

    @Autowired
    private ReadReportService readReportService;

    @PostMapping
    public ResponseEntity<Void> readFile() {
        readReportService.readFile();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
