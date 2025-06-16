package com.Krav.api.InterfaceAdapters.Controllers;

import com.Krav.api.Infra.Mapping.AutoMapper;
import com.Krav.api.InterfaceAdapters.DTOs.AuthDTO;
import com.Krav.api.InterfaceAdapters.DTOs.ProdutosDTO;
import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.UsersCase.ProdutosCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produtos")
public class ControllerProdutos {

    @Autowired
    public ProdutosCase produtosCase;

    @Operation(summary = "Criar Produto", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping
    public String RegistraProduto(@RequestBody ProdutosDTO produtosDTO) {
        Produtos produtos = AutoMapper.MapProdutos(produtosDTO);
        produtosCase.Registration(produtos);
        return produtosCase.toString();
    }

    @GetMapping
    public List<Produtos> getAllProdutos(){
        return produtosCase.Find();
    }

    @PutMapping
    public void UpdateProdutos(@RequestBody ProdutosDTO produtosDTO) {
        Produtos produtos = AutoMapper.MapProdutos(produtosDTO);
        produtosCase.Update(produtos);
    }

    @DeleteMapping
    public void DeleteProdutos(@RequestBody ProdutosDTO produtosDTO) {
        Produtos produtos = AutoMapper.MapProdutos(produtosDTO);
        produtosCase.Delete(produtos);
    }


}
