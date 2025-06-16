package com.Krav.api.InterfaceAdapters.Controllers;

import com.Krav.api.Infra.Mapping.AutoMapper;
import com.Krav.api.InterfaceAdapters.DTOs.AuthDTO;
import com.Krav.api.InterfaceAdapters.DTOs.ProdutosDTO;
import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.UsersCase.ProdutosCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Produtos")
public class ControllerProdutos {

    @Autowired
    public ProdutosCase produtosCase;
    @PostMapping
    public void RegistraProduto(@RequestBody ProdutosDTO produtosDTO) {
        Produtos produtos = AutoMapper.MapProdutos(produtosDTO);
        produtosCase.Registration(produtos);
    }
}
