package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.service.opinions.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

}
