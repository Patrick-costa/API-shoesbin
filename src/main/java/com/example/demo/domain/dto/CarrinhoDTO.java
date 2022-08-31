package com.example.demo.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;


import com.example.demo.domain.Carrinho;
import com.example.demo.domain.Produto;


public class CarrinhoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	
	protected Integer clienteId;
	
	@NotNull(message = "Carrinho vazio")
	private List<Produto> produto = new ArrayList<>();
	
	private Boolean status;

	public CarrinhoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarrinhoDTO(Carrinho obj) {
		super();
		this.id = obj.getId();
		this.clienteId = obj.getClienteId();
		this.produto = obj.getProduto();
		this.status = obj.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
}
