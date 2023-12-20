package com.quovadis.nyeriyouth.youthregistration.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quovadis.nyeriyouth.youthregistration.models.Deanery;
import com.quovadis.nyeriyouth.youthregistration.models.Parish;
import com.quovadis.nyeriyouth.youthregistration.repositories.DeaneryRepo;
import com.quovadis.nyeriyouth.youthregistration.repositories.ParishRegistrationRepo;
import com.quovadis.nyeriyouth.youthregistration.repositories.YouthRegistrationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final YouthRegistrationRepo youthRegistrationRepo;
    private final ParishRegistrationRepo parishRegistrationRepo;
    private final DeaneryRepo deaneryRepo;
    private final ObjectMapper objectMapper;


    public DataLoader(YouthRegistrationRepo youthRegistrationRepo, ParishRegistrationRepo parishRegistrationRepo, DeaneryRepo deaneryRepo, ObjectMapper objectMapper) {
        this.youthRegistrationRepo = youthRegistrationRepo;
        this.parishRegistrationRepo = parishRegistrationRepo;
        this.deaneryRepo = deaneryRepo;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
//        if (true){
//            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/deaneries.json")){
//                deaneryRepo.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Deanery>>(){} ));
//            }
//        }
//                if (true){
//            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/parishes.json")){
//                parishRegistrationRepo.saveAll(objectMapper.readValue(inputStream,new TypeReference<List<Parish>>(){} ));
//            }
//        }
//                parishRegistrationRepo.deleteAll();

    }
}

