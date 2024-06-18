
package com.senai.vendas.repository;

import com.senai.vendas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
    Produto findByNomeProduto(String nomeProduto);
}
