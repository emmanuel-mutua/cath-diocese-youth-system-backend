package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;

public record Parish(
        @Id
        Long parishId,
        Long deaneryId,
        String parishName

) {
}
