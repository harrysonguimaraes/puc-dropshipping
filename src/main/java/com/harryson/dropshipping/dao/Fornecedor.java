package com.harryson.dropshipping.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@JsonIgnore
	private String token;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@JsonIgnore
	public String getToken() {
		return token;
	}
	@JsonProperty
	public void setToken(String token) {
		this.token = token;
	}
}
