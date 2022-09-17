package com.example.demo.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Favoritos;
import com.example.demo.domain.Produto;

public class FavoritosDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotNull(message = "O Campo PRODUTO é requerido")
	private Produto produto;
	private Integer idUsuario;
	
	public FavoritosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavoritosDTO(Favoritos obj) {
		super();
		this.id = obj.getId();
		this.produto = obj.getProduto();
		this.idUsuario = obj.getIdUsuario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
}
