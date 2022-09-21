package com.example.demo.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Produto;
import com.example.demo.domain.Venda;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VendaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	protected Float valor = (float) 0.0;;
	
	protected Integer clienteId;
	@NotNull(message = "O Campo PRODUTO é requerido")
	protected List<Produto> produto = new ArrayList<>();

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
		this.valor = calculaTotal(obj);
		this.clienteId = obj.getClienteId();
		this.produto = obj.getProduto();
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

	float calculaTotal(Venda obj) {
		List<ProdutoDTO> list = obj.getProduto().stream().map((x) -> new ProdutoDTO(x)).collect(Collectors.toList());
		
		for(ProdutoDTO item : list) {
			this.valor  += item.getPreco().floatValue(); 
		}
		
		return this.valor;
	}
	

}
