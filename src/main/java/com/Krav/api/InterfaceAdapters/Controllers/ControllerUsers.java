package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.InterfaceAdapters.DTOs.UsersDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Users")
public class ControllerUsers {

    @PostMapping()
    public void Registration(@RequestBody UsersDTO usersDTO) {

    }

}
