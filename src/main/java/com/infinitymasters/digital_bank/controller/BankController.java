package com.infinitymasters.digital_bank.controller;

import com.infinitymasters.digital_bank.model.BankModel;
import com.infinitymasters.digital_bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    @Autowired // helps in injecting dependencies
    private BankService bankService;

    // Types of communication protocols -> GET, POST, PATCH, DELETE -> HTTP Request modes
    //    API Endpoint -> /fetch-banks -> this is where we can make requests
    //  youtube.com/pewdipie -> represents pewdipie channel to access easily
   //  localhost:8080/fetch-banks -> API endpoint to access from local machine
    @GetMapping("/fetch-banks")
    public List<BankModel> getAllBanksFromDatabase() {
        List<BankModel> allBanksFromDatabase = bankService.getAllBanksFromDatabase();
        return allBanksFromDatabase;
    }

    @PostMapping("/add-bank")
    public void addBankToDatabase(@RequestBody BankModel bankModel) {
        bankService.storeBankIntoDatabase(bankModel);
    }

    @DeleteMapping("/delete-bank/{bank-id}")
    public void deleteBankFromDatabase(@PathVariable("bank-id") Long bankId) {
        bankService.deleteBankFromDatabase(bankId);
    }

    @PatchMapping("/update-bank")
    public void updateBankInDatabase(@RequestBody BankModel bankModel) {
        bankService.updateBankInfoInDatabase(bankModel);
    }
}
