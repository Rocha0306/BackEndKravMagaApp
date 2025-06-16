package com.Krav.api.InterfaceAdapters.Database.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Produtos {

    @Id
    private UUID id;


    private String Nome;

    private Integer Quantidade;

    private Integer Preco;



}
