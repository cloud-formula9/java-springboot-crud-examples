package com.infinitymasters.digital_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotations -> They simplify configuration process
@SpringBootApplication
public class DigitalBankApplication {

    // entry point of the application
    public static void main(String[] args) {

//        run -> static method
//        SpringApplication -> Java Class
//        DigitalBankApplication.class, args -> method arguments
        SpringApplication.run(DigitalBankApplication.class, args);
    }
}
