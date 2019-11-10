package com.harryson.dropshipping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.harryson.dropshipping.dao.Produto;

@RepositoryRestResource(collectionResourceRel = "produtos", path = "produtos")
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
	List<Produto> findByDescricaoContaining(String descricao);

}
