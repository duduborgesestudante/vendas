
package com.senai.vendas.repository;

import com.senai.vendas.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
    Cliente findByCpf(String cpf);
    
}
