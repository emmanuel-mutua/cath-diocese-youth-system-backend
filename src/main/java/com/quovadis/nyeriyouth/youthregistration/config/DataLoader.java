package com.quovadis.nyeriyouth.youthregistration.config;

import com.quovadis.nyeriyouth.youthregistration.models.Deanery;
import com.quovadis.nyeriyouth.youthregistration.repositories.DeaneryRepo;
import com.quovadis.nyeriyouth.youthregistration.repositories.ParishRegistrationRepo;
import com.quovadis.nyeriyouth.youthregistration.repositories.YouthRegistrationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final YouthRegistrationRepo youthRegistrationRepo;
    private final ParishRegistrationRepo parishRegistrationRepo;
    private final DeaneryRepo deaneryRepo;


    public DataLoader(YouthRegistrationRepo youthRegistrationRepo, ParishRegistrationRepo parishRegistrationRepo, DeaneryRepo deaneryRepo) {
        this.youthRegistrationRepo = youthRegistrationRepo;
        this.parishRegistrationRepo = parishRegistrationRepo;
        this.deaneryRepo = deaneryRepo;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

