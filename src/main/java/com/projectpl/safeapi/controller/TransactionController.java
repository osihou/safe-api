package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.service.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/functions/get-cities/{key}")
    Iterable<String> getCities (
            @RequestParam(value = "country", defaultValue = "India") String country,
            @PathVariable(value = "key") String key
    ){
        if(key.equals("secret_key")){
            return transactionService.getCities(country);
        }
        return null;
    }
    @GetMapping("/functions/get-top-in-cities/{key}")
    Iterable<Location> getTopPlacesInCity(
            @RequestParam(value = "country", defaultValue = "India") String country,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "num", defaultValue = "5") String num,
            @PathVariable(value = "key") String key

    ){

        if(key.equals("secret_key")){
            return transactionService.getTopPlacesInCity(country, city,  num);
        }

        return null;

    }

    @GetMapping("/functions/get-id-where-name-street/{name}/{street}/{key}")
    int getIdWhereNameStreet(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "name") String street,
            @PathVariable(value = "key") String key
    ){
        if(key.equals("secret_key")){
            return transactionService.getIdWhereNameStreet(name,street);
        }

        return 0;
    }

}
