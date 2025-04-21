package com.example.FarmerService.helper;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {

    public static boolean hasExcelFormat(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx");
    }
}
