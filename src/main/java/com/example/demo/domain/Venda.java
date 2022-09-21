package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.example.demo.domain.dto.VendaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected Float valor;
	
	protected Integer clienteId;
	
	@ManyToMany
	private List<Produto> produto = new ArrayList<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime data = LocalDateTime.now();
	
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalDateTime hora = LocalDateTime.now();
	
	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venda(VendaDTO obj) {
		super();
		this.id = obj.getId();
		this.valor = obj.getValor();
		this.clienteId = obj.getClienteId();
		this.produto = obj.getProduto();
	}

	public Venda(Integer id, Float valor, Integer clienteId, List<Produto> produto) {
		super();
		this.id = id;
		this.valor = valor;
		this.clienteId = clienteId;
		this.produto = produto;
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
	
	
}
