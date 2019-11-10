package com.harryson.dropshipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harryson.dropshipping.dao.Fornecedor;
import com.harryson.dropshipping.dao.Produto;
import com.harryson.dropshipping.repository.FornecedorRepository;
import com.harryson.dropshipping.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@GetMapping
	public Iterable<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
    @GetMapping(value = "/find-by-descricao")
    public Iterable<Produto> findByDescricao(@RequestParam("descricao") String descricao) {
        return produtoRepository.findByDescricaoContaining(descricao);
    }
    
    @PostMapping
    public Produto save(@RequestBody Produto produto, @RequestHeader(value="token")String token) {
    	
    	Fornecedor fornecedor = fornecedorRepository.findByToken(token);
    	produto.setFornecedor(fornecedor);
    	return produtoRepository.save(produto);
    }

}
