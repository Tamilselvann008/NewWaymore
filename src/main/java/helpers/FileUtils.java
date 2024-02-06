package helpers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileUtils {

    private static final String storage = "../../storage";
    private static final String chromeStorageRemotePath = "../../storage/chrome/*";
    private static final String downloads = "../../downloads";

    public static String createFolder(String folderPath) {
        Path path = Paths.get(folderPath);
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path.toAbsolutePath().toString();
    }

    public static String createFolderWithinFolder(String folderPath, String innerFolder) {
        createFolder(folderPath);
        Path innerFolderPath = Paths.get(folderPath, innerFolder);
        if (!Files.exists(innerFolderPath)) {
            try {
                Files.createDirectory(innerFolderPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return innerFolderPath.toAbsolutePath().toString();
    }

    public static void deleteFolderWithRimraf(String folderPath) {
        Path pathToFolder = Paths.get(folderPath);
        try {
            Files.walk(pathToFolder)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFilesInDirectory(String dir) {
        Path directory = Paths.get(dir);
        try {
            Files.walk(directory)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileContents(String dirName, String folderPath, String fileName) {
        Path filePath = Paths.get(dirName, folderPath, fileName);
        try {
            return Files.readString(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isFileExist(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    public static List<List<String>> readXlsxFile(String fileName) {
        List<List<String>> data = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                    Row row = sheet.getRow(j);
                    List<String> rowData = new ArrayList<>();
                    for (int k = 0; k < row.getLastCellNum(); k++) {
                        Cell cell = row.getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        rowData.add(cell.toString());
                    }
                    data.add(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String readPdfFile(String pdfFilePath) {
        // Implement PDF reading logic here (library needed)
        return null;
    }

    public static String readCsvFile(String csvFilePath) {
        try {
            return Files.readString(Paths.get(csvFilePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

