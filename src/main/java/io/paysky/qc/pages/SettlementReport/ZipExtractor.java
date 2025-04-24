package io.paysky.qc.pages.SettlementReport;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.*;

    public class ZipExtractor {

        public static void unzip(String zipFilePath, String destDir) {
            File latestFile = getLatestFileFromDir(zipFilePath);
            File dir = new File(destDir);
            if (!dir.exists()) dir.mkdirs();
            byte[] buffer = new byte[1024];
            try {
                ZipInputStream zis = new ZipInputStream(new FileInputStream(latestFile));
                ZipEntry zipEntry = zis.getNextEntry();
                while (zipEntry != null) {
                    File newFile = newFile(dir, zipEntry);
                    if (zipEntry.isDirectory()) {
                        newFile.mkdirs();
                    } else {
                        // create parent directories
                        new File(newFile.getParent()).mkdirs();
                        FileOutputStream fos = new FileOutputStream(newFile);
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                        fos.close();
                    }
                    zipEntry = zis.getNextEntry();
                }
                zis.closeEntry();
                zis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // To prevent Zip Slip vulnerability
        public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
            File destFile = new File(destinationDir, zipEntry.getName());
            String destDirPath = destinationDir.getCanonicalPath();
            String destFilePath = destFile.getCanonicalPath();
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
            }
            return destFile;
        }
        public static File getLatestFileFromDir(String dirPath) {
            File dir = new File(dirPath);
            File[] files = dir.listFiles(File::isFile);

            if (files == null || files.length == 0) {
                System.out.println("No files found in the directory.");
                return null;
            }

            // Sort by last modified time, descending
            Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

            return files[0]; // First one is the most recently modified
        }

    }

