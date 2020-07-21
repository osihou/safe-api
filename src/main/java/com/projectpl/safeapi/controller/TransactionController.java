package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.entity.Location;
import com.projectpl.safeapi.service.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/functions/get-cities")
    Iterable<String> getCities (@RequestParam(value = "country", defaultValue = "India") String country){
        return transactionService.getCities(country);
    }
    @GetMapping("/functions/get-top-in-cities")
    Iterable<Location> getTopPlacesInCity(
            @RequestParam(value = "country", defaultValue = "India") String country,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "num", defaultValue = "5") String num
    ){
        return transactionService.getTopPlacesInCity(country, city,  num);
    }

}
