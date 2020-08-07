package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;



}
