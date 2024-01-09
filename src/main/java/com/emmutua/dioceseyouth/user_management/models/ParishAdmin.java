package com.emmutua.dioceseyouth.user_management.models;

import org.springframework.data.annotation.Id;

public record ParishAdmin(
        @Id
        Integer id,
        String username,
        Integer parishId,
        String password
) {
}
