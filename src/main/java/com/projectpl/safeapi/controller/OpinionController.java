package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.entity.Opinion;
import com.projectpl.safeapi.service.opinions.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @GetMapping("/opinions/all/{key}")
    Iterable<Opinion> getAllOpinions(
            @PathVariable("key") String key
    ){
        if(key.equals("secret_key")){
            return opinionService.findAll();
        }

        return null;

    }

    @PostMapping("/add/opinions/{key}")
    public Opinion insertOpinion(
            @RequestBody Opinion newOpinion,
            @PathVariable("key") String key
    ){

        if(key.equals("secret_key")){
            return opinionService.save(newOpinion);
        }

        return null;

    }
}
