package com.example.demo.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Carrinho;
import com.example.demo.domain.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VendaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O Campo VALOR é requerido")
	protected Float valor;
	
	protected Integer clienteId;
	@NotNull(message = "O Campo CARRINHO é requerido")
	protected Carrinho carrinho;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalDateTime hora = LocalDateTime.now();
	
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
