package com.example.FarmerService.helper;

import com.example.FarmerService.entity.Farmer;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelParser {

    public static List<Farmer> parseExcel(MultipartFile file) {
        List<Farmer> farmers = new ArrayList<>();

        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) rows.next(); // skip header

            while (rows.hasNext()) {
                Row row = rows.next();

                Farmer farmer = Farmer.builder()
                        .fullName(row.getCell(0).getStringCellValue())
                        .email(row.getCell(1).getStringCellValue())
                        .phoneNumber(row.getCell(2).getStringCellValue())
                        .location(row.getCell(3).getStringCellValue())
                        .build();

                farmers.add(farmer);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }

        return farmers;
    }
}
