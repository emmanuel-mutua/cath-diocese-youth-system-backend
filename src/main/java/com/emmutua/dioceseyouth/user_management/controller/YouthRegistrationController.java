package com.emmutua.dioceseyouth.user_management.controller;

import com.emmutua.dioceseyouth.user_management.models.*;
import com.emmutua.dioceseyouth.user_management.repositories.*;
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
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "https://adnyeriyouth-1t5nyd1d9-youthmanagementnyeri.vercel.app", "https://adnyeriyouth.vercel.app"})
@RequestMapping("api/v1")
public class YouthRegistrationController {
    private final YouthRegistration youthRegistrationRepo;
    private final ParishRegistrationRepo parishRegistrationRepo;
    private final DeaneryRepo deaneryRepo;
    private final UserRepository userRepository;
    private final AdminRepo adminRepo;
    private final ParishAdminRepo parishAdminRepo;


    public YouthRegistrationController(YouthRegistration youthRegistrationRepo,ParishRegistrationRepo parishRegistrationRepo, DeaneryRepo deaneryRepo, UserRepository userRepository, AdminRepo adminRepo, ParishAdminRepo parishAdminRepo) {
        this.youthRegistrationRepo = youthRegistrationRepo;
        this.parishRegistrationRepo = parishRegistrationRepo;
        this.deaneryRepo = deaneryRepo;
        this.userRepository = userRepository;
        this.adminRepo = adminRepo;
        this.parishAdminRepo = parishAdminRepo;
    }

    @GetMapping("/youth")
    public List<Youth> findAllYouths(){
        return youthRegistrationRepo.findAll();
    }
    @GetMapping("/users")
    public List<Userr> getAllAdmins(){
        return adminRepo.findAll();
    }
    @GetMapping("youth/{id}")
    public Optional<Youth>findYouthById(@PathVariable Long id){
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
        return parishRegistrationRepo.findAllByDeaneryId(deanery_id);
    }


    @GetMapping("/youth/parish/{parishId}")
    public List<Youth> findByParishId(@PathVariable Integer parishId){
        return youthRegistrationRepo.findAllByParishId(parishId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/youth/register")
    public void create(@Valid @RequestBody Youth nyeriYouth){
            youthRegistrationRepo.save(nyeriYouth);
    }

    @PostMapping("/login/{userType}")
    public ResponseEntity<Map<String, String>> loginAdmin(@RequestBody Map<String,Object> userMap, @PathVariable String userType){
        String username = (String) userMap.get("username");
        String password = (String) userMap.get("password");
        Map<String, String> map = new HashMap<>();
        if ("admin".equals(userType)){
            boolean exists = userRepository.existsUserrByUsernameAndPasswordAndUserRole(username,password,userType).isPresent();

            if (exists){
                map.put("message", "Login Success");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }else {
                map.put("message", "Invalid username/password");
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        }else {
            Optional<ParishAdmin> parishAdmin = parishAdminRepo.findParishAdminByUsername(username);
            if (parishAdmin.isPresent()){
                Integer parishId = parishAdmin.get().getParishId();
                String parishAdminPwd = parishAdmin.get().getPassword();
                if (!password.equals(parishAdminPwd)){
                    map.put("message", "Invalid username/password");
                    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
                }else {
                    map.put("message", "Login Success");
                    map.put("parishId", "" + parishId);
                    return new ResponseEntity<>(map, HttpStatus.OK);
                }
            }else {
                map.put("message", "Invalid username/password");
                return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
            }
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addUser")
    public void addUser(@Valid @RequestBody Userr userr){
        if (adminRepo.findAllByUsername(userr.getUsername()).isEmpty()){
            adminRepo.save(userr);
        }else {
            throw new ResponseStatusException(HttpStatus.FOUND, "User Exists");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addParishAdmin")
    public void addParishAdmin(@Valid @RequestBody ParishAdmin parishAdmin){
        Boolean adminExistsByParishId= parishAdminRepo.findAllByParishId(parishAdmin.getParishId()).isEmpty();
        Boolean adminExistsByUserName = parishAdminRepo.findAllByUsername(parishAdmin.getUsername()).isEmpty();
        if (!adminExistsByParishId) {
            throw new ResponseStatusException(HttpStatus.FOUND, "Parish Admin Exists in the selected parish");
        }
        if (!adminExistsByUserName){
            throw new ResponseStatusException(HttpStatus.FOUND, "UserName taken");
        }
        try {
            parishAdminRepo.save(parishAdmin);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/youth/{id}")
    public void updateYouthData(@Valid @RequestBody Youth nyeriYouth, @PathVariable Long id){
        if (!youthRegistrationRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        youthRegistrationRepo.save(nyeriYouth);
    }

    @DeleteMapping("/youth/delete/{idOrBirthCertNumber}")
    public void deleteYouth(@PathVariable String idOrBirthCertNumber){
        youthRegistrationRepo.deleteYouthByBirthCertNumber(idOrBirthCertNumber);
    }

}
