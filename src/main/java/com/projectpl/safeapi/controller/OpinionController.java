package com.projectpl.safeapi.controller;

import com.google.gson.internal.$Gson$Preconditions;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.service.opinions.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpinionController {

    @Autowired
    private OpinionService opinionService;


    @GetMapping(
            path = "/opinion/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Opinion> getAll(){
        return opinionService.findAll();
    }

    @GetMapping(
            path = "/opinion/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Opinion getOpinionById(
            @PathVariable int id
    ){
        return opinionService.findById(id);
    }

    @GetMapping(
            path = "/opinion/location_id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Opinion getOpinionByScoreId(
            @PathVariable int id
    ){
        return opinionService.findByLocationKey(id);
    }


    @PostMapping(
            path = "/opinion",
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public void postOpinion(
            @RequestBody Opinion opinion
        ){
        opinionService.save(opinion);

    }

    @GetMapping(
            path = "/opinion/delete/{id}")
    public void deleteOpinionById(
            @PathVariable int id
    ){
        opinionService.deleteById(id);
    }



}
