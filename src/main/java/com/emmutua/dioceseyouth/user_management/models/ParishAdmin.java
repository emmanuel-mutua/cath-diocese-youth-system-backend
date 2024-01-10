package com.emmutua.dioceseyouth.user_management.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParishAdmin{
        @Id
        @GeneratedValue
        Integer id;
        String username;
        Integer parishId;
        String password;
}
