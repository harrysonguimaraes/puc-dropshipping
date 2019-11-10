package com.harryson.dropshipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harryson.dropshipping.dao.Fornecedor;
import com.harryson.dropshipping.exception.UnauthorizedException;
import com.harryson.dropshipping.repository.FornecedorRepository;

@RestController
@RequestMapping("/api/v1/fornecedores")
public class FornecedorController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
    @PostMapping
    public Fornecedor save(@RequestBody Fornecedor fornecedor, @RequestHeader(value="token") String token) {
    	
    	if(token != null && token.equals("ADMIN")) {
        	return fornecedorRepository.save(fornecedor);    		
    	}
    	else {
    		throw new UnauthorizedException();
    	}

    }

}
