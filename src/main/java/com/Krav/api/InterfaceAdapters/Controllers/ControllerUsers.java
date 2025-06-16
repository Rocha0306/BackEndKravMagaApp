package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.Infra.Mapping.AutoMapper;
import com.Krav.api.InterfaceAdapters.DTOs.UsersDTO;
import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;
import com.Krav.api.InterfaceAdapters.Database.Repository.UsersRepository;
import com.Krav.api.UsersCase.UsersCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class ControllerUsers {

    private final UsersCase usersCase;

    private UsersRepository usersRepository;

    @Autowired
    public ControllerUsers(UsersCase usersCase, UsersRepository usersRepository) {
        this.usersCase = usersCase;
        this.usersRepository = usersRepository;
    }
    @PostMapping
    public void Registration(@RequestBody UsersDTO usersDTO) throws InterruptedException {
        Usuarios users = AutoMapper.MapUsers(usersDTO);
        usersCase.Registration(users);
    }




}
