package com.example.railways.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter long adminId;
    
    @Column(unique = true)
    private @Getter @Setter String adminUsername;
    
    @Column
    private @Getter @Setter String adminPassword;

    
}
