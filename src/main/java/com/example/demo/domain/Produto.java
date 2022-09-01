package com.example.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected String titulo;
	protected String marca;
	protected String tamanho;
	protected String descricao;
	protected String imagem;
	protected Boolean status;
	protected Integer quantidade;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(ProdutoDTO obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.tamanho = obj.getTamanho();
		this.descricao = obj.getDescricao();
		this.marca = obj.getMarca();
		this.imagem = obj.getImagem();
		this.status = obj.getStatus();
		this.quantidade = obj.getQuantidade();
	}

	
	
	public Produto(Integer id, String titulo, String marca, String tamanho, String descricao, String imagem,
			Boolean status, Integer quantidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.marca = marca;
		this.tamanho = tamanho;
		this.descricao = descricao;
		this.imagem = imagem;
		this.status = status;
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
}
