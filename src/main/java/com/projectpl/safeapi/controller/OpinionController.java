package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Opinion;
import com.projectpl.safeapi.service.opinions.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @GetMapping("/opinions/all")
    Iterable<Opinion> getAllOpinions(){
        return opinionService.findAll();
    }
}
