/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.vendas.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author eduardo_cambraia
 */

@Entity
@Table(name="vendas_produto")
public class VendasProduto {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdVendasProduto;
    
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable=false)
    private Vendas vendas;
    
    
    @OneToOne
    @JoinColumn(nullable=false)
    private Produto produto;
    
    @Column(nullable=false)
    private Double precoVenda;
    
    @Column(nullable=false)
    private Integer quantidade;

    public Long getIdVendasProduto() {
        return IdVendasProduto;
    }

    public void setIdVendasProduto(Long IdVendasProduto) {
        this.IdVendasProduto = IdVendasProduto;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
   
    
    
}
