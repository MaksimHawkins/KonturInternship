package com.github.kontur;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvHandler {

    public void handleFile(Path path) {
        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .build();

            BufferedReader bufferedReader = Files.newBufferedReader(path);

            CSVReader reader = new CSVReaderBuilder(bufferedReader)
                    .withCSVParser(parser)
                    .build();

            List<String[]> rows = reader.readAll();
            for (String[] row: rows) {
                Unit unit = new Unit(row[0], row[1], Double.parseDouble(row[2]));
                Core.getUnitManager().addUnit(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Failed to convert a coefficient of measure unit");
            e.printStackTrace();
        }
    }
}
