package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.errors.exceptions.LocationNotFoundException;
import com.projectpl.safeapi.persistance.entity.Location;
import com.projectpl.safeapi.persistance.entity.Opinion;
import com.projectpl.safeapi.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping(
            path = "/location/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Location> getAll(){
        return locationService.findAll();
    }

    @GetMapping(
            path = "/location/{key}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Location getOpinionById(
            @PathVariable int id
    ){
        return locationService.findById(id);
    }

    @PostMapping(
            path = "/location",
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public void postOpinion(
            @RequestBody Location location
    ){
        locationService.save(location);

    }


    @GetMapping(
            path = "/location/delete/{id}")
    public void deleteOpinionById(
            @PathVariable int id
    ){
        locationService.deleteById(id);
    }





}
