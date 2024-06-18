package com.senai.vendas.service;

import com.senai.vendas.entity.Cliente;
import com.senai.vendas.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
 
    
    public Long incluirCliente(Cliente cliente){
        
        if(cliente.getNome() == null || cliente.getNome() == ""){
            return null;
        }
        if(cliente.getEmail() == null || cliente.getEmail() == ""){
            return null;
        }
        if(cliente.getCpf() == null || cliente.getCpf() == ""){
            return null;
        }
        
        if(cliente.getCpf() == null ||
           cliente.getCpf() == "" ||
           cliente.getCpf().length() != 11 ||
           ! cliente.getCpf().chars().allMatch(Character::isDigit)){
            return null;
        }
        if(clienteRepository.findByCpf(cliente.getCpf()) == null){
            return clienteRepository.save(cliente).getIdCliente();
        }
        return null;
    }
    
    public boolean excluirCliente(Long IdCliente){
      if(clienteRepository.findById(IdCliente).isPresent()){
          clienteRepository.deleteById(IdCliente);
          return true;
      }
        return false;
    }
    
    public boolean alterarCliente(Cliente cliente){
        
        if(cliente.getNome() == null || cliente.getNome() == ""){
        return false;
    }
        if(cliente.getEmail() == null || cliente.getEmail() == ""){
        return false;
    }
         if(cliente.getCpf() == null ||
           cliente.getCpf() == "" ||
           cliente.getCpf().length() != 11 ||
           ! cliente.getCpf().chars().allMatch(Character::isDigit)){
            return false;
        }
         Cliente cliBD = clienteRepository.getReferenceById(cliente.getIdCliente());
       
        if( cliBD != null){
        if(cliBD.getCpf() != cliente.getCpf() &&
            clienteRepository.findByCpf(cliente.getCpf()) != null){    
            return false;
         }
        
        cliBD.setCelular(cliente.getCelular());
        cliBD.setCpf(cliente.getCpf());
        cliBD.setEmail(cliente.getEmail());
        cliBD.setNascimento(cliente.getNascimento());
        cliBD.setNome(cliente.getNome());
        clienteRepository.save(cliBD);
        return true;
        }
        return false;
    }

    public Cliente consultaClientePorId(Long IdCliente){
        return clienteRepository.findById(IdCliente).get();
    }
    
    public Cliente consultaClientePorCpf(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
    
    public List<Cliente> listarCliente(){
        return clienteRepository.findAll();
    }

    
}