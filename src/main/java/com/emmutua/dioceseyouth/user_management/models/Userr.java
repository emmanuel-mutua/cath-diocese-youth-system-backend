package com.emmutua.dioceseyouth.user_management.models;

import jakarta.persistence.Column;
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
public class Userr{
        @Id
        @GeneratedValue
        @Column(name = "userId")
        Long id;
        String username;
        String password;
        String userRole;
        }

