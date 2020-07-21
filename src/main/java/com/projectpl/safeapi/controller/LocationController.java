package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.exception.LocationNotFoundException;
import com.projectpl.safeapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations/all")
    Iterable<Location> getAllLocations(){
        return locationService.findAll();
    }
    @GetMapping("/locations/id/{id}")
    Location getLocationById(@PathVariable("id") int id){
        return locationService.findById(id);
    }

    @GetMapping("/locations/name/{name}")
    Location getLocationByName(@PathVariable("name") String name){
        return locationService.findByName(name);
    }

    @GetMapping("/locations/city/{city}")
    Iterable<Location> getLocationByCity(@PathVariable("city") String city){
        return locationService.findByCity(city);
    }



}
