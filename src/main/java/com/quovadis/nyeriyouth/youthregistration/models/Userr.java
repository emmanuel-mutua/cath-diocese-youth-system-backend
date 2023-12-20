package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;

public record Userr(
        @Id
        Integer userId,
        String username,
        String password,
        String userRole
) {
}
