package Utils;


import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    public static List<LinkedHashMap<String, String>> getExcelDataListAsMap(String fileName, String sheetName) throws IOException {
        List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();
        Workbook workbook =  WorkbookFactory.create(new File("src/test/resources/testData/"+fileName+".xlsx"));
        Sheet sheet =  workbook.getSheet(sheetName);
        int totalNumber = sheet.getPhysicalNumberOfRows();
        LinkedHashMap<String, String> mapData;
        List<String> allKeys = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();
        for (int i = 0; i < totalNumber; i++) {
            mapData = new LinkedHashMap<>();
            if (i == 0) {
                int totalCol = sheet.getRow(0).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCol; j++) {
                    allKeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
                }
            }
            else {
                int totalCol = sheet.getRow(i).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCol; j++) {
                    String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                    mapData.put(allKeys.get(j), cellValue);
                }
                dataFromExcel.add(mapData);
            }
        }
        return dataFromExcel;
    }




    public static String getExcelDataListAsString(String fileName, String sheetName) throws IOException {
        List<LinkedHashMap<String, String>> dataFromExcel = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File("src/test/resources/testData/" + fileName + ".xlsx"));
        Sheet sheet = workbook.getSheet(sheetName);
        int totalNumber = sheet.getPhysicalNumberOfRows();
        LinkedHashMap<String, String> mapData;
        List<String> allKeys = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();
        for (int i = 0; i < totalNumber; i++) {
            mapData = new LinkedHashMap<>();
            if (i == 0) {
                int totalCol = sheet.getRow(0).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCol; j++) {
                    allKeys.add(sheet.getRow(0).getCell(j).getStringCellValue());
                }
            } else {
                int totalCol = sheet.getRow(i).getPhysicalNumberOfCells();
                for (int j = 0; j < totalCol; j++) {
                    String cellValue = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                    mapData.put(allKeys.get(j), cellValue);
                }
                dataFromExcel.add(mapData);
            }
        }

        // Convert the dataFromExcel list to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dataFromExcel);

        return jsonString;
    }
}

