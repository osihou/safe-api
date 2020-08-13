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
            path = "/location/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Location getLocationById(
            @PathVariable int id
    ){
        return locationService.findById(id);
    }

    @PostMapping(
            path = "/location",
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public void postLocation(
            @RequestBody Location location
    ){
        locationService.save(location);

    }


    @DeleteMapping(
            path = "/location/{id}")
    public void deleteLocationById(
            @PathVariable int id
    ){
        locationService.deleteById(id);
    }





}
