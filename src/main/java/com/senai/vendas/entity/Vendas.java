/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.vendas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author eduardo_cambraia
 */

@Entity
@Table(name="vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdVendas;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable=false)
    private Cliente cliente;
    
    @Column(nullable=false)
    private Date dataVenda;
    
    @Column(nullable=false)
    private int situacao;

    @OneToMany(mappedBy="vendas", fetch=FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<VendasProduto> vendasproduto;

   

    //GETTERS AND SETTERS

    public Set<VendasProduto> getVendasproduto() {
        return vendasproduto;
    }

    public void setVendasproduto(Set<VendasProduto> vendasproduto) {
        this.vendasproduto = vendasproduto;
    }

    
    
    
    public Long getIdVendas() {
        return IdVendas;
    }

    public void setIdVendas(Long IdVendas) {
        this.IdVendas = IdVendas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    
  
    
}
