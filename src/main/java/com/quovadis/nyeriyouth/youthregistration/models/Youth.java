package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public record Youth(
        @Id
        Integer serialNumber,
        String fullName,
        LocalDate dateOfBirth,
        String phoneNumber,
        String gender,
        String idOrBirthCertNumber,
        String localChurchName,
        String smallChristianCommunityName,
        Integer parishId,
        Integer deaneryId,
        Boolean baptized,
        Boolean receivedHolyCommunion,
        Boolean confirmation,
        Boolean married
) {

}

