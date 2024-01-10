package com.emmutua.dioceseyouth.user_management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Name;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Youth {
        @Id
        @GeneratedValue
        @Column(name = "serialNumber")
        Long id;
        String fullName;
        LocalDate dateOfBirth;
        String phoneNumber;
        String gender;
        @Column(name = "idOrBirthCertificateNumber")
        String birthCertNumber;
        String localChurchName;
        String smallChristianCommunityName;
        Integer parishId;
        Integer deaneryId;
        Boolean baptized;
        Boolean receivedHolyCommunion;
        Boolean confirmation;
        Boolean married;
}

