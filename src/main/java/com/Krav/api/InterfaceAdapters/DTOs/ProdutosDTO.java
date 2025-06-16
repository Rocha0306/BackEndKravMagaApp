package com.Krav.api.InterfaceAdapters.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class ProdutosDTO {

        @NotBlank
        public String id;

        @NotBlank
        public String nome;

        @NotBlank
        public int quantidade;

        @NotBlank
        public int preco;
}
