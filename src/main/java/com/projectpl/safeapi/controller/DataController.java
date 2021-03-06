package com.projectpl.safeapi.controller;

import com.itextpdf.text.DocumentException;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.service.email.EmailService;
import com.projectpl.safeapi.service.opinions.IOpinionService;
import com.projectpl.safeapi.utils.PdfRaportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DataController {

    @GetMapping("/home")
    String home(){
        return ":)";
    }

    @Autowired
    private IOpinionService opinionService;


    @RequestMapping(
            value = "/pdf_report",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    @CrossOrigin(origins = "*")
    public ResponseEntity<InputStreamResource> opinionsReport() throws DocumentException, IOException, URISyntaxException {

        List<Opinion> opinions = (List<Opinion>) opinionService.findAll();

        ByteArrayInputStream bis = PdfRaportGenerator.opinionsReport(opinions);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=opinions_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(
            value = "/pdf_report2",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    @CrossOrigin(origins = "*")
    public ResponseEntity<InputStreamResource> opinionsReport2() throws IOException {

        ClassPathResource bis  = new ClassPathResource("pdf/raport.pdf");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=opinions_report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis.getInputStream()));
    }



}
