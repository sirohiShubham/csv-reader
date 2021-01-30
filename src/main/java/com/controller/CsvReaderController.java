package com.controller;

import com.dto.CsvReaderDto;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.CsvReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
public class CsvReaderController {
    @Autowired
    private CsvReader csvReader;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadCsv(@RequestParam("inputFile") MultipartFile inputFile, Model model) {
        if (inputFile.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(inputFile.getInputStream()))) {
                CsvToBean<CsvReaderDto> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(CsvReaderDto.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                List<CsvReaderDto> csvReaderDtoList = csvToBean.parse();

                csvReader.save(csvReaderDtoList);

                model.addAttribute("data", "Success");
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        return "file-upload-status";
    }

    @RequestMapping("/test")
    public String test() {
        return "System Alive";
    }
}
