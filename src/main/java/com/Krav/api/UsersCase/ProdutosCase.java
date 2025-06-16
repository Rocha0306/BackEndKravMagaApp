package com.Krav.api.UsersCase;

import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import com.Krav.api.InterfaceAdapters.Database.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ProdutosCase extends CrudCases<Produtos> {


    @Autowired
    private ProdutosRepository produtosRepository;
    @Override
    public Produtos Update(Produtos produtos) {
        return null;
    }

    @Override
    public Produtos Delete(Produtos produtos) {
        return null;
    }

    @Override
    public Produtos Find(Produtos produtos) {
        return null;
    }

    @Override
    public void Registration(Produtos produtos) {
        produtos.setId(UUID.randomUUID());
        produtosRepository.save(produtos);
    }
}
