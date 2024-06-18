
package com.senai.vendas.controller;

import com.senai.vendas.entity.Cliente;
import com.senai.vendas.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping("/cliente")
    public ResponseEntity<Long> incluirNovoCliente(@RequestBody Cliente cliente){
        Long idCli = clienteService.incluirCliente(cliente);
        if(idCli != null){
            return new ResponseEntity<>(idCli, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }//POST  http://localhost:8010/vendas/cliente
    
    
    @DeleteMapping("/cliente/{IdCliente}")
    public ResponseEntity<Long> exluirCliente(@PathVariable ("IdClient")Long IdCliente){
        if(clienteService.excluirCliente(IdCliente)){
            return new ResponseEntity<>(HttpStatus.OK);
        }       
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }//DELETE  http://localhost:8010/vendas/cliente/{id}
    
    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> listCli = clienteService.listarCliente();
        if(! listCli.isEmpty()){
            return new ResponseEntity<>(listCli ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }//GET  http://localhost:8010/vendas/cliente
    
    
    
    @GetMapping("/cliente/id/{IdCliente}")
    public ResponseEntity<Cliente> consultaClientePorId(
    @PathVariable("IdCliente") Long IdCliente){
        Cliente cliente = clienteService.consultaClientePorId(IdCliente);
        if(cliente != null){
            return new ResponseEntity<>(cliente ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }//GET  http://localhost:8010/vendas/cliente/id/idcliente

    
    
      @GetMapping("/cliente/cpf/{cpf}")
    public ResponseEntity<Cliente> consultaClientePorCpf(
    @PathVariable("cpf") String cpf){
        Cliente cliente = clienteService.consultaClientePorCpf(cpf);
        if(cliente != null){
            return new ResponseEntity<>(cliente ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }//GET  http://localhost:8010/vendas/cliente/cpf/{cpf}

    @PutMapping("cliente")
    public ResponseEntity<Boolean> alterarCliente(@RequestBody Cliente cliente){
       if(clienteService.alterarCliente(cliente)){
           return new ResponseEntity<>(true, HttpStatus.OK);
       }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }//POST  http://localhost:8010/vendas/cliente
}
