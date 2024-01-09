package com.emmutua.dioceseyouth.user_management.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.emmutua.dioceseyouth.user_management.repositories.DeaneryRepo;
import com.emmutua.dioceseyouth.user_management.repositories.ParishRegistrationRepo;
import com.emmutua.dioceseyouth.user_management.repositories.YouthRegistrationRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

