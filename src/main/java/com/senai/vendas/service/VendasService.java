/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.vendas.service;

import com.senai.vendas.entity.Cliente;
import com.senai.vendas.entity.Vendas;
import com.senai.vendas.repository.VendasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendasService {
    
   @Autowired
   private VendasRepository vendasRepository;
   
   @Autowired
   private ClienteService clienteService;
   
   public Long incluirVendas(Vendas vendas, Long IdCliente){
       Cliente cliente = clienteService.consultaClientePorId(IdCliente);
       if(cliente == null|| vendas.getDataVenda() == null || vendas.getSituacao() == 0 ){
           return null;
       }
       vendas.setCliente(cliente);
       return vendasRepository.save(vendas).getIdVendas();
   }
   
   public boolean excluirVenda(Long IdVendas){
       if(vendasRepository.existsById(IdVendas)){
           vendasRepository.deleteById(IdVendas);
           return true;
       }
       return false;
   }
   
   public Vendas consultarVendaPorId(Long IdVendas){
       return vendasRepository.findById(IdVendas).get();
   }
   
   public Vendas consultarVendaPorCliente(Long IdCliente){
       Cliente cliente = clienteService.consultaClientePorId(IdCliente);
       if(cliente != null){
           return vendasRepository.findByCliente(cliente);
       }
       return null;
   }
   
   public List<Vendas>listarVendas(){
       return vendasRepository.findAll();
   }
   
   public boolean alterarVenda(Vendas vendas){
       Vendas vendasBD = vendasRepository.getReferenceById(vendas.getIdVendas());
       if(vendasBD != null){
           vendasBD.setDataVenda(vendas.getDataVenda());
           vendasBD.setSituacao(vendas.getSituacao());
           vendasRepository.save(vendasBD);
           return true;
       }
       return false;
   }
}
