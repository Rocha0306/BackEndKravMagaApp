package com.Krav.api.InterfaceAdapters.Database.Repository;

import com.Krav.api.InterfaceAdapters.Database.Entities.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface ProdutosRepository extends JpaRepository<Produtos, UUID> {
}
