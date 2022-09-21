package com.example.demo.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String logradouro;
	private String localidade;
	private String uf;
	private String bairro;
	private String cep;
	private Integer numero;
	private String complemento;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Endereco(Integer id, String logradouro, String localidade, String uf, String bairro, String cep,
			Integer numero, String complemento) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.uf = uf;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	
	
}
