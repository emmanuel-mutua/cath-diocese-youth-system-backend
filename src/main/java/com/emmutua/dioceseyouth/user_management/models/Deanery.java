package com.emmutua.dioceseyouth.user_management.models;

import org.springframework.data.annotation.Id;

public record Deanery(
        @Id
        Integer deaneryId,
        String deaneryName
) {
}
