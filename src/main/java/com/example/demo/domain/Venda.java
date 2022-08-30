package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.domain.dto.VendaDTO;

@Entity
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected Float valor;
	
	protected Integer clienteId;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@OneToOne
	protected Carrinho carrinho;
	
	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venda(VendaDTO obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.clienteId = obj.getClienteId();
		this.carrinho = obj.getCarrinho();
	}

	public Venda(Integer id, Float valor, Integer clienteId, Carrinho carrinho) {
		super();
		this.id = id;
		this.valor = valor;
		this.clienteId = clienteId;
		this.carrinho = carrinho;
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
