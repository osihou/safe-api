package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.entity.Opinion;
import com.projectpl.safeapi.service.locations.LocationService;
import com.projectpl.safeapi.service.opinions.OpinionService;
import com.projectpl.safeapi.service.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataController implements IDataController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    String getDefault(){
        return "Welcome";
    }

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

    @PostMapping("/add/locations/{key}")
    public Location insertLocation(
            @RequestBody Location newLocation,
            @PathVariable("key") String key
    ){

        if(key.equals("secret_key")){
            return locationService.save(newLocation);
        }

        return null;

    }

    @DeleteMapping("/del/locations/{id}/{key}")
    public void deleteLocationById(
            @PathVariable int id,
            @PathVariable("key") String key
    ) {
        if(key.equals("secret_key")){
            locationService.deleteById(id);
        }
    }

    @Autowired
    private OpinionService opinionService;

    @PostMapping("/add/opinions/{key}")
    public Opinion insertOpinions(
            @RequestBody Opinion newOpinion,
            @PathVariable("key") String key
    ){
        if(key.equals("secret_key")){
            return opinionService.save(newOpinion);
        }

        return null;

    }










}
