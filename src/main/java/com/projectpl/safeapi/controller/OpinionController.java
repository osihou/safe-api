package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.service.opinions.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpinionController {

    @Autowired
    private OpinionService opinionService;


    @RequestMapping(
            path = "/opinion/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Opinion> getAll(){
        return opinionService.findAll();
    }

    @RequestMapping(
            path = "/opinion/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Opinion getOpinionById(
            @PathVariable int id
    ){
        return opinionService.findById(id);
    }

    @RequestMapping(
            path = "/opinion/location_id/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Opinion getOpinionByScoreId(
            @PathVariable int id
    ){
        return opinionService.findByLocationKey(id);
    }


    @RequestMapping(
            path = "/opinion",
            method = RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public void postOpinion(
            @RequestBody Opinion opinion
        ){
        opinionService.save(opinion);

    }

    @RequestMapping(
            path = "/opinion/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void putOpinion(
            @RequestBody Opinion newOpinion,
            @PathVariable int id
    ){
        opinionService.updateOpinion(newOpinion, id);
    }

    @RequestMapping(
            path = "/opinion/{id}",
            method = RequestMethod.DELETE
    )
    public void deleteOpinionById(
            @PathVariable int id
    ){
        opinionService.deleteById(id);
    }






}
