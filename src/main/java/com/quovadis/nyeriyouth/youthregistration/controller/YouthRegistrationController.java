package com.quovadis.nyeriyouth.youthregistration.controller;

import com.quovadis.nyeriyouth.youthregistration.models.Deanery;
import com.quovadis.nyeriyouth.youthregistration.models.Parish;
import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import com.quovadis.nyeriyouth.youthregistration.repositories.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class YouthRegistrationController {
    private final YouthRegistrationRepo youthRegistrationRepo;
    private final ParishRepoJdbcTemplate parishRepo;
    private final ParishRegistrationRepo parishRegistrationRepo;
    private final DeaneryRepo deaneryRepo;
    private final YouthRegistrationJdbcTemplate youthRegistrationRepoCustom;


    public YouthRegistrationController(YouthRegistrationRepo youthRegistrationRepo, ParishRepoJdbcTemplate parishRepo, ParishRegistrationRepo parishRegistrationRepo, DeaneryRepo deaneryRepo, YouthRegistrationJdbcTemplate youthRegistrationRepoCustom) {
        this.youthRegistrationRepo = youthRegistrationRepo;
        this.parishRepo = parishRepo;
        this.parishRegistrationRepo = parishRegistrationRepo;
        this.deaneryRepo = deaneryRepo;
        this.youthRegistrationRepoCustom = youthRegistrationRepoCustom;
    }

    @GetMapping("/youth")
    public List<Youth> findAllYouths(){
        return youthRegistrationRepo.findAll();
    }

    @GetMapping("youth/{id}")
    public Optional<Youth>findYouthById(@PathVariable Integer id){
        return Optional.ofNullable(youthRegistrationRepo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not found.")
        ));
    }
    @GetMapping("/parishes")
    public List<Parish> findAllParishes(){
        return parishRegistrationRepo.findAll();
    }
    @GetMapping("/deaneries")
    public List<Deanery> findAllDeaneries(){
        return deaneryRepo.findAll();
    }
    @GetMapping("/parishes/{deanery_id}")
    public List<Parish> findAllParishesByDeanery(@PathVariable Integer deanery_id){
        return parishRepo.findAllByDeaneryId(deanery_id);
    }


    @GetMapping("/youth/parish/{parishId}")
    public List<Youth> findByParishId(@PathVariable Integer parishId){
        return youthRegistrationRepoCustom.getYouthByParishId(parishId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/youth/register")
    public void create(@Valid @RequestBody Youth nyeriYouth){
        youthRegistrationRepo.save(nyeriYouth);
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, String>> loginAdmin(@RequestBody Map<String,Object> userMap){
        String username = (String) userMap.get("username");
        String password = (String) userMap.get("password");
        boolean ok = youthRegistrationRepoCustom.validateAdmin(username,password);
        Map<String, String> map = new HashMap<>();
        if (ok){
            map.put("message", "Login Success");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else {
            map.put("message", "Invalid username/password");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/youth/{id}")
    public void updateYouthData(@Valid @RequestBody Youth nyeriYouth, @PathVariable Integer id){
        if (!youthRegistrationRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        youthRegistrationRepo.save(nyeriYouth);
    }

    @DeleteMapping("/youth/delete/{idOrBirthCertNumber}")
    public void deleteYouth(@PathVariable String idOrBirthCertNumber){
        youthRegistrationRepoCustom.deleteYouthByCertOrIdNumber(idOrBirthCertNumber);
    }
}
