package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;

public record Parish(
        @Id
        Integer parishId,
        Integer deaneryId,
        String parishName

) {
}
