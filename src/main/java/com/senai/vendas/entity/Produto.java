/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.vendas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * @author eduardo_cambraia
 */

@Entity
@Table(name="produto")
public class Produto {
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdProduto;
    
    @Column(nullable=false)
    private String nomeProduto;
    
    @Column(nullable=true)
    private String descricao;
    
    @Column(nullable=false)
    private Integer quantidade;
    
    @Column(nullable=false)
    private Double precoCusto;
    
    @Column(nullable=false)
    private Double precoVenda;
    
    @Column(nullable=true)
    private Date validade;

    
    @OneToOne
    private VendasProduto vendasproduto;
    
    
    
   //GETTERS AND SETTERS DOS GURIZÃO 

    public Long getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(Long IdProduto) {
        this.IdProduto = IdProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public VendasProduto getVendasproduto() {
        return vendasproduto;
    }

    public void setVendasproduto(VendasProduto vendasproduto) {
        this.vendasproduto = vendasproduto;
    }

 
    
}

