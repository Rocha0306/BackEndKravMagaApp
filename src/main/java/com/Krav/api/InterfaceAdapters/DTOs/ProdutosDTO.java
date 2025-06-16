package com.Krav.api.InterfaceAdapters.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

import java.util.UUID;

@Getter
@Setter
public class ProdutosDTO {

        @NotBlank
        public UUID id;

        @NotBlank
        public String nome;

        @NotBlank
        public int quantidade;

        @NotBlank
        public int preco;
}
