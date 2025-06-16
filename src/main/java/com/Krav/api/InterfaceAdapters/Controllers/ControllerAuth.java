package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.Infra.Security.ServiceUserDetails;
import com.Krav.api.InterfaceAdapters.DTOs.AuthDTO;
import com.Krav.api.InterfaceAdapters.DTOs.TokenDTO;
import com.Krav.api.InterfaceAdapters.Libs.TokenService;
import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;
import com.Krav.api.InterfaceAdapters.Database.Repository.UsersRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerAuth {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ServiceUserDetails serviceUserDetails;
    @PostMapping("/Auth")
    @Operation(summary = "Endpoint de Autenticaçao, é necessário se autenticar para consumir")
    public TokenDTO Login(@RequestBody AuthDTO auth) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(auth.Email(), auth.Senha());
        var Auth = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        TokenService tokenService = new TokenService();
        String Token = tokenService.generateToken(auth.Email());
        return new TokenDTO(Token);
    }


}
