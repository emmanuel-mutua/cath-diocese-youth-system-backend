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
@AllArgsConstructor
@NoArgsConstructor
public class Deanery{
        @Id
        @GeneratedValue
        @Column(name = "deaneryId")
        Integer id;
        String deaneryName;
        }
