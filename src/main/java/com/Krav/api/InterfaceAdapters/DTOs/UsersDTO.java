package com.Krav.api.InterfaceAdapters.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {

    @NotBlank
    public String Nome;
    @NotBlank
    public String Sobrenome;
    @NotBlank
    public String Senha;
    @NotBlank
    @Email
    public String Email;
    @NotBlank
    public String Faixa;

}
