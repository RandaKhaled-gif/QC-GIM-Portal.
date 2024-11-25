package org.example.Utilits;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.List;

public class CSVUtilits {
    public static List<String[]> readCSV(String filepath) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(filepath));
        List<String[]> allData = csvReader.readAll();
        csvReader.close();
        if (!allData.isEmpty()){
            allData.remove(0);
        }
        return allData;
    }

}
