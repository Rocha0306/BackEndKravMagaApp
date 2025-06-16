package com.Krav.api.Infra.Mapping;



import com.Krav.api.InterfaceAdapters.DTOs.ProdutosDTO;
import com.Krav.api.InterfaceAdapters.DTOs.UsersDTO;
import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.InterfaceAdapters.Database.Entities.Usuarios;

public class AutoMapper {

   public static Usuarios MapUsers(UsersDTO usersDTO) {
       Usuarios users = new Usuarios();
       users.setNome(usersDTO.getNome());
       users.setSobrenome(usersDTO.getSobrenome());
       users.setSenha(usersDTO.getSenha());
       users.setEmail(usersDTO.getEmail());
       users.setFaixa(usersDTO.getFaixa());
       return users;
   }

   public static Produtos MapProdutos(ProdutosDTO produtosDTO) {
       Produtos produtos = new Produtos();
       produtos.setNome(produtosDTO.getNome());
       produtos.setPreco(produtosDTO.getPreco());
       produtos.setQuantidade(produtosDTO.getQuantidade());
       return produtos;
   }
}
