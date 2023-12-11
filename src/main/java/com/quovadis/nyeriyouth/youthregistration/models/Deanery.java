package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;

public record Deanery(
        @Id
        Long deaneryId,
        String deaneryName
) {
}
