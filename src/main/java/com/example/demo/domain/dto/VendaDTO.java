package com.example.demo.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Carrinho;
import com.example.demo.domain.Venda;

public class VendaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O Campo VALOR é requerido")
	protected Float valor;
	
	protected Integer clienteId;
	@NotNull(message = "O Campo CARRINHO é requerido")
	protected Carrinho carrinho;

	public VendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendaDTO(Venda obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.clienteId = obj.getClienteId();
		this.carrinho = obj.getCarrinho();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	

}
