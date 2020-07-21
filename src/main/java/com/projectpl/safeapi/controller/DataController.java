package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.service.LocationService;
import com.projectpl.safeapi.service.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController implements IDataController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/dev-functions/dall")
    String deleteAll(@RequestParam(value = "key", defaultValue = "none") String key){
        if(key.equals("eol")){
            transactionService.removeAll();
            return "Removed!";
        }else{
            return "Please provide key";
        }
    }

    @Autowired
    private LocationService locationService;

    @PostMapping("/locations")
    public Location insertLocation(@RequestBody Location newLocation){
        return locationService.save(newLocation);
    }

    @DeleteMapping("/locations/{id}")
    public void deleteLocationById(@PathVariable int id) {
        locationService.deleteById(id);
    }





}
