package com.infinitymasters.digital_bank.repository;

import com.infinitymasters.digital_bank.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankModel, Long> {
}
