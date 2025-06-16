package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.Infra.Notifications.Emails;
import com.Krav.api.InterfaceAdapters.DTOs.AuthDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Permissao")
public class ControllerPermissao {

    @Autowired
    private Emails emails;
    @GetMapping
    @Operation(summary = "Se quiser adm manda seus dados que pensamos no seu caso")
    public void VerificaPermissao(@RequestBody AuthDTO authDTO) {
        List<String> gestores = List.of("l.m.p.rocha2005@gmail.com", "albertstanley927@gmail.com", "lucaskravmaga@gmail.com");
        emails.SendEmail(gestores, "Permissao Instrutor", "Avaliar se usuario pode ter acesso de instrutor");

    }

}
