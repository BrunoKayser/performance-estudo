package com.geracao.relatorio.performance.utils;

import com.geracao.relatorio.performance.domain.enums.PositionsCsvEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CSVCompanyUtils {

    public static boolean hasInvalidValue(String field) {
        return "".equals(field) || "-".equals(field) || "0".equals(field);
    }
}
