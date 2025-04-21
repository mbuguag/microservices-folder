package com.example.FarmerService.service;

import com.example.FarmerService.entity.Farmer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

@Service
public class FarmerExcelService {

    private final RabbitTemplate rabbitTemplate;

    public FarmerExcelService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void processAndSendToQueue(MultipartFile file) {
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();

            if (iterator.hasNext()) iterator.next(); // Skip header

            while (iterator.hasNext()) {
                Row row = iterator.next();
                Farmer farmer = new Farmer();

                farmer.setFullName(getStringValue(row.getCell(0)));
                farmer.setNationalId(getStringValue(row.getCell(1)));
                farmer.setPhoneNumber(getStringValue(row.getCell(2)));
                farmer.setEmail(getStringValue(row.getCell(3)));
                farmer.setLocation(getStringValue(row.getCell(4)));

                rabbitTemplate.convertAndSend("farmer.queue", farmer);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage(), e);
        }
    }

    private String getStringValue(Cell cell) {
        return cell == null ? "" : cell.getStringCellValue().trim();
    }
}
