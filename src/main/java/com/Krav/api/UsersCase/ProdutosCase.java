package com.Krav.api.UsersCase;

import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.InterfaceAdapters.Database.Repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class ProdutosCase extends CrudCases<Produtos> {


    @Autowired
    private ProdutosRepository produtosRepository;
    @Override
    @Transactional
    public Produtos Update(Produtos produtoparametro) {
       Produtos produtodatabase = produtosRepository.findByNome(produtoparametro.getNome());
       if(produtodatabase == null) {
           throw new IllegalArgumentException("Nao tem no banco lixo");
       }
       produtoparametro.setId(produtodatabase.getId());
       produtosRepository.save(produtoparametro);
       return produtoparametro;
    }

    @Override
    @Transactional
    public Produtos Delete(Produtos produtoparametro) {
        Produtos produtodatabase = produtosRepository.findByNome(produtoparametro.getNome());
        if(produtodatabase == null) {
            throw new IllegalArgumentException("Nao tem no banco lixo");
        }
        produtoparametro.setId(produtodatabase.getId());
        produtosRepository.delete(produtoparametro);
        return produtodatabase;
    }

    @Override
    public List<Produtos> Find() {
        List<Produtos> produtosList = produtosRepository.findAll();
        return produtosList;
    }

    @Override
    public void Registration(Produtos produtos) {
        produtos.setId(UUID.randomUUID());
        produtosRepository.save(produtos);
    }
}
