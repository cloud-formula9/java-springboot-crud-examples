package com.infinitymasters.digital_bank.service;

import com.infinitymasters.digital_bank.model.BankModel;
import com.infinitymasters.digital_bank.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j // used to annotate and print
@Service // helps spring in understanding that this is a service layer
// service is basically used to store the entire business logic
public class BankService {

    @Autowired // injects the needed dependencies into this class
    private BankRepository bankRepository;

//    READ operation
    public List<BankModel> getAllBanksFromDatabase() {
        List<BankModel> listOfBanks = bankRepository.findAll();// fetches all the records from DB
        return listOfBanks;
    }

//    CREATE Operation
    public void storeBankIntoDatabase(BankModel bankModel) {
        bankRepository.save(bankModel);
    }

//    UPDATE Operation
    public void updateBankInfoInDatabase(BankModel bankModel) {

        log.info(String.valueOf(bankModel.bankId));
        Optional<BankModel> getBankById = bankRepository.findById(bankModel.bankId);

        log.info(String.valueOf(getBankById.isPresent()));
        if (getBankById.isPresent()) {
            BankModel toBeUpdatedBank = getBankById.get();
            log.info(String.valueOf(getBankById.get()));
            toBeUpdatedBank.setBankMarketCapital(bankModel.bankMarketCapital);
            log.info(String.valueOf(toBeUpdatedBank));

            bankRepository.save(toBeUpdatedBank);
        }
    }

//    DELETE Operation
    public void deleteBankFromDatabase(Long bankId) {
        bankRepository.deleteById(bankId);
    }

}
