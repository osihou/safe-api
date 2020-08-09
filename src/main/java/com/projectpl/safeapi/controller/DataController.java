package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.service.email.EmailService;
import com.projectpl.safeapi.service.opinions.IOpinionService;
import com.projectpl.safeapi.utils.PdfRaportGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
public class DataController implements IDataController {

    @Autowired
    private EmailService emailService;


    @GetMapping("/home")
    String home(){
        return "Its working";
    }

    @GetMapping("/test_mail")
    String testMail() {
        //emailService.sendMail("okeonx@gmail.com", "test", "test test \n test test");
        emailService.sendPreConfiguredMail("Weź się do roboty frajerze");
        return "Email sent";

    }


    @Autowired
    private IOpinionService opinionService;

    @RequestMapping(
            value = "/pdf_report",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> opinionsReport() {

        List<Opinion> opinions = (List<Opinion>) opinionService.findAll();

        ByteArrayInputStream bis = PdfRaportGenerator.opinionsReport(opinions);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=opinionsreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }



}
