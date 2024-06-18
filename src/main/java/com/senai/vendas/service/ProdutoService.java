
package com.senai.vendas.service;

import com.senai.vendas.entity.Produto;
import com.senai.vendas.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Long incluirProduto(Produto produto){
        if(produto.getNomeProduto() == null ||
            produto.getPrecoCusto()== null ||
            produto.getPrecoVenda()== null ||
            produto.getQuantidade()== null ){
            return null; 
        }
        return produtoRepository.save(produto).getIdProduto();
    }
    
    
     public boolean excluirProduto(Long IdProduto){
      if(produtoRepository.findById(IdProduto).isPresent()){
          produtoRepository.deleteById(IdProduto);
          return true;
      }
        return false;
    }

     public Produto consultarProdutoPorId(Long IdProduto){
         Optional<Produto> produto = produtoRepository.findById(IdProduto);
         if(produto.isPresent()){
             return produto.get();
         }
         return null;
         
     }
     
     public List<Produto> listarProduto(){
         return produtoRepository.findAll();
     }
     public Produto consultarProdutoPorNome(String nomeProduto){
         return produtoRepository.findByNomeProduto(nomeProduto);
     }
     public boolean alterarProduto(Produto produto){
        if(produto.getNomeProduto() == null ||
            produto.getPrecoCusto()== null ||
            produto.getPrecoVenda()== null ||
            produto.getQuantidade()== null ){
            return false; 
        }
        
        Produto prodDB= produtoRepository.getReferenceById(produto.getIdProduto());
         if(prodDB != null){
             prodDB.setDescricao(produto.getDescricao());
             prodDB.setNomeProduto(produto.getNomeProduto());
             prodDB.setPrecoCusto(produto.getPrecoCusto());
             prodDB.setPrecoVenda(produto.getPrecoVenda());
             prodDB.setQuantidade(produto.getQuantidade());
             prodDB.setValidade(produto.getValidade());
             
             produtoRepository.save(prodDB);
             return true;
         }
         return false;
     
     
}}    

    

