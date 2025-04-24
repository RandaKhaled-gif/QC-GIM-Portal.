package io.paysky.qc.pages.SettlementReport;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileNameValidator {

    public static void validateFilesInFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles(File::isFile);

        if (files == null || files.length == 0) {
            System.out.println("No files found in the folder.");
            return;
        }

        System.out.println("File count: " + files.length);
        for (File file : files) {
            System.out.println("File Name: " + file.getName());
        }

        System.out.println("\n--- File Name Breakdown & Validation ---");

        // Get yesterday's Julian date
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String yy = String.valueOf(yesterday.getYear()).substring(2);
        int julianDay = yesterday.getDayOfYear();
        String yyddd = yy + String.format("%03d", julianDay);

        for (File file : files) {
            String fileName = file.getName();
            System.out.println("\nAnalyzing: " + fileName);

            // Remove extension if any
            String nameWithoutExt = fileName.contains(".") ? fileName.substring(0, fileName.lastIndexOf('.')) : fileName;

            // Split by underscore "_"
            String[] parts = nameWithoutExt.split("_");
            for(String part : parts)
            {
                System.out.println(part);
            }

            if (parts.length == 6) {
                // Validate and extract each part
                if (!parts[0].equals("rLIS")) {
                    System.out.println(" First part is not 'rLIS': " + parts[0]);
                } else if (!parts[1].equals("OUT")) {
                    System.out.println(" Second part is not 'OUT': " + parts[1]);
                } else if (!parts[5].equals("01")) {
                    System.out.println(" Last part is not '01': " + parts[5]);
                } else if (!parts[4].equals(yyddd)) {
                    System.out.println(" Julian date part doesn't match yesterday's date: " + parts[4]);
                } else {
                    // All good, print name parts
                    System.out.println("✅ Format is valid!");
                    System.out.println("Start of file:" + parts[0]+ "_" + parts[1]);
                    System.out.println("Name1: " + parts[2]);
                    System.out.println("Name2: " + parts[3]);
                    System.out.println("Julian Date (YYDDD): " + parts[4]);
                    System.out.println("End of file:" + parts[5]);
                }
            }
            if (parts.length == 7) {
// Validate and extract each part
                if (!parts[0].equals("rLIS")) {
                    System.out.println(" First part is not 'rLIS': " + parts[0]);
                } else if (!parts[1].equals("OUT")) {
                    System.out.println(" Second part is not 'OUT': " + parts[1]);
                } else if (!parts[6].equals("01")) {
                    System.out.println(" Last part is not '01': " + parts[6]);
                } else if (!parts[5].equals(yyddd)) {
                    System.out.println(" Julian date part doesn't match yesterday's date: " + parts[5]);
                } else {
                    // All good, print name parts
                    System.out.println("✅ Format is valid!");
                    System.out.println("Start of file:" + parts[0]+ "_" + parts[1]);
                    System.out.println("Bank Name: " + parts[2]);
                    System.out.println("Processer Name: " + parts[3] + "_" + parts[4]);
                    System.out.println("Julian Date (YYDDD): " + parts[5]);
                    System.out.println("End of file:" + parts[6]);
                }
            }

        }
    }
}
