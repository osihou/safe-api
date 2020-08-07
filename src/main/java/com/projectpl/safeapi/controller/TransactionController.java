package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.service.transactions.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


}
