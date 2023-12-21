package com.quovadis.nyeriyouth.youthregistration.models;

import org.springframework.data.annotation.Id;

public record ParishAdmin(
        @Id
        Integer id,
        String userName,
        Integer parishId,
        String password
) {
}
