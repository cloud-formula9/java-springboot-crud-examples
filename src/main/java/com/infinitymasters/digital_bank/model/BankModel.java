package com.infinitymasters.digital_bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // creates getter and setter methods instead of developer writing code for them.
@Entity // tells compiler that this is an database related class
@Table(name = "banks") // helps in creating a table inside database
public class BankModel {

    @Id
    public Long bankId;
    public String bankName;
    public int bankMarketCapital;
}
