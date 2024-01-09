package com.emmutua.dioceseyouth.user_management.models;

import org.springframework.data.annotation.Id;

public record Parish(
        @Id
        Integer parishId,
        Integer deaneryId,
        String parishName

) {
}
