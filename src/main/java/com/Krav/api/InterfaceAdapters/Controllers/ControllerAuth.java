package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.InterfaceAdapters.DTOs.TokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
public class ControllerAuth {

    @PostMapping
    public void Login() {
    }

}
