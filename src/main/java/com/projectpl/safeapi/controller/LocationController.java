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


    @RequestMapping(
            path = "/location/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<Location> getAll(){
        return locationService.findAll();
    }

    @RequestMapping(
            path = "/location/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Location getLocationById(
            @PathVariable int id
    ){
        return locationService.findById(id);
    }

    @RequestMapping(
            path = "/location",
            method = RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public void postLocation(
            @RequestBody Location location
    ){
        locationService.save(location);

    }


    @RequestMapping(
            path = "/location/{id}",
            method = RequestMethod.DELETE
    )
    public void deleteLocationById(
            @PathVariable int id
    ){
        locationService.deleteById(id);
    }





}
