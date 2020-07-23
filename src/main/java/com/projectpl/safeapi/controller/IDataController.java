package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IDataController {

    Location insertLocation(
            @RequestBody Location newLocation,
            @PathVariable("key") String key);

    void deleteLocationById(
            @PathVariable int id,
            @PathVariable("key") String key);
}
