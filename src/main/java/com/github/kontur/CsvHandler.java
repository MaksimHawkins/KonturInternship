package com.github.kontur;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvHandler {

    File csvData = new File("/path/to/csv");

    public void testHandle() {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("D:\\Dev\\ufo.csv"));

            CSVReader reader = new CSVReaderBuilder(bufferedReader)
                    .withCSVParser(parser)
                    .build();

            List<String[]> rows = reader.readAll();
            for (String[] row: rows) {
                System.out.println(row[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
