package com.Krav.api.InterfaceAdapters.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {

    @NotBlank
    private String Nome_Completo;
    @NotBlank
    private String Password;
    @NotBlank
    private String Numero_Celular;

}
