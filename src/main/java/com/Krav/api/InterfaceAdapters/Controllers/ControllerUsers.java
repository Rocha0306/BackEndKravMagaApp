package com.Krav.api.InterfaceAdapters.Controllers;


import com.Krav.api.Infra.Mapping.AutoMapper;
import com.Krav.api.InterfaceAdapters.DTOs.MessageDTO;
import com.Krav.api.InterfaceAdapters.DTOs.ProdutosDTO;
import com.Krav.api.InterfaceAdapters.DTOs.UsersDTO;
import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;
import com.Krav.api.InterfaceAdapters.Database.Repository.UsersRepository;
import com.Krav.api.UsersCase.UsersCase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class ControllerUsers {

    private final UsersCase usersCase;

    @Autowired
    public ControllerUsers(UsersCase usersCase) {
        this.usersCase = usersCase;
    }
    @Operation(summary = "Cadastro basicamente")
    @PostMapping
    public MessageDTO Registration(@RequestBody UsersDTO usersDTO) throws InterruptedException {
        Usuarios users = AutoMapper.MapUsers(usersDTO);
        usersCase.Registration(users);
        return new MessageDTO("Cadastrado com sucesso");
    }

    @GetMapping
    @Operation(summary = "Edita infos de alunos, mas só admins")
    public List<Usuarios> getAllAlunos(){
        return usersCase.Find();
    }

    @PutMapping
    @Operation(summary = "Edita infos de alunos, mas só admins")
    public void UpdateProdutos(@RequestBody UsersDTO usersDTO) {
        Usuarios usuarios = AutoMapper.MapUsers(usersDTO);
        usersCase.Update(usuarios);
    }

    @DeleteMapping
    @Operation(summary = "Exclui alunos da academia, mas só admins")
    public void DeleteProdutos(@RequestBody UsersDTO usersDTO) {
        Usuarios usuarios = AutoMapper.MapUsers(usersDTO);
        usersCase.Update(usuarios);
    }




}
