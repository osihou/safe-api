package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations/all/{key}")
    Iterable<Location> getAllLocations(
            @PathVariable("key") String key
    ){
        if(key.equals("secret_key")){
            return locationService.findAll();
        }
        return null;
    }

    @GetMapping("/locations/id/{id}/{key}")
    Location getLocationById(
            @PathVariable("id") int id,
            @PathVariable("key") String key
    ){
        if(key.equals("secret_key")){
            return locationService.findById(id);
        }
        return null;
    }

    @GetMapping("/locations/name/{name}/{key}")
    Location getLocationByName(
            @PathVariable("name") String name,
            @PathVariable("key") String key
            ){

        if(key.equals("secret_key")){
            return locationService.findByName(name);
        }
        return null;
    }

    @GetMapping("/locations/city/{city}/{key}")
    Iterable<Location> getLocationByCity(
            @PathVariable("city") String city,
            @PathVariable("key") String key
            ){

        if(key.equals("secret_key")){
            return locationService.findByCity(city);
        }
        return null;

    }



}
