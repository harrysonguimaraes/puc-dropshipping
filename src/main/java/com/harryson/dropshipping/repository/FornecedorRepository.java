package com.harryson.dropshipping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harryson.dropshipping.dao.Fornecedor;

@RepositoryRestResource(collectionResourceRel = "fornecedores", path = "fornecedores")
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long>{

	Fornecedor findByToken(String token);

}
