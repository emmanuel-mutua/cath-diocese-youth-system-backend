package com.quovadis.nyeriyouth.youthregistration.config;

import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import com.quovadis.nyeriyouth.youthregistration.repositories.YouthRegistrationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final YouthRegistrationRepo youthRegistrationRepo;


    public DataLoader(YouthRegistrationRepo youthRegistrationRepo) {
        this.youthRegistrationRepo = youthRegistrationRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save the NyeriYouth object during application startup

    }
}

