package com.emmutua.dioceseyouth.user_management.models;

import org.springframework.data.annotation.Id;

public record Userr(
        @Id
        Integer userId,
        String username,
        String password,
        String userRole
) {
}
