package com.quovadis.nyeriyouth.youthregistration.controller;

import com.quovadis.nyeriyouth.youthregistration.models.Youth;
import com.quovadis.nyeriyouth.youthregistration.repositories.YouthRegistrationRepo;
import com.quovadis.nyeriyouth.youthregistration.repositories.YouthRegistrationJdbcTemplate;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class YouthRegistrationController {
    private final YouthRegistrationRepo youthRegistrationRepo;
    private final YouthRegistrationJdbcTemplate youthRegistrationRepoCustom;


    public YouthRegistrationController(YouthRegistrationRepo youthRegistrationRepo, YouthRegistrationJdbcTemplate youthRegistrationRepoCustom) {
        this.youthRegistrationRepo = youthRegistrationRepo;
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
