package com.Krav.api.InterfaceAdapters.Database.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Usuarios {

    @Id
    private UUID Id;

    private String nome;

    private String sobrenome;

    private String senha;

    private String email;

    private String faixa;

    private String role;



    
}
