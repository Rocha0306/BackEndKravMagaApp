package com.Krav.api.Entities;


import jakarta.persistence.*;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Enumerated(EnumType.STRING)
    private RolesApplication Role_Names;
}
