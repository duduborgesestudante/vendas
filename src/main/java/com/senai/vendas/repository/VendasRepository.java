
package com.senai.vendas.repository;

import com.senai.vendas.entity.Cliente;
import com.senai.vendas.entity.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas,Long> {
    
    Vendas findByCliente(Cliente cliente);
}
