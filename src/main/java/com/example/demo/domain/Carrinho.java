package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.example.demo.domain.dto.CarrinhoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Carrinho implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected Integer clienteId;
	
	@JoinColumn(name="produto_id")
	@ManyToMany
	private List<Produto> produto = new ArrayList<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	private Boolean status;
	
	public Carrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrinho(CarrinhoDTO obj) {
		super();
		this.id = obj.getId();
		this.clienteId = obj.getClienteId();
		this.produto = obj.getProduto();
		this.status = obj.getStatus();
	}
	
	public Carrinho(Integer id, Integer clienteId, List<Produto> produto, Boolean status) {
		super();
		this.id = id;
		this.produto = produto;
		this.status = status;
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
