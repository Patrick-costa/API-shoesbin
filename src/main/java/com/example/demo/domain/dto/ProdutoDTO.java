package com.example.demo.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProdutoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O Campo TITULO é requerido")
	protected String titulo;
	@NotNull(message = "O Campo TAMANHO é requerido")
	protected String tamanho;
	@NotNull(message = "O Campo DESCRICAO é requerido")
	protected String descricao;
	@NotNull(message = "O Campo MARCA é requerido")
	protected String marca;
	@NotNull(message = "O Campo IMAGEM é requerido")
	@NotNull(message = "O Campo PRECO é requerido")
	protected Float preco;
	protected String imagem;
	
	protected Boolean status;
	@NotNull(message = "O Campo QUANTIDADE é requerido")
	protected Integer quantidade;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.tamanho = obj.getTamanho();
		this.descricao = obj.getDescricao();
		this.marca = obj.getMarca();
		this.imagem = "https://shoesbin.s3.sa-east-1.amazonaws.com/" + System.currentTimeMillis() + "_" + obj.getImagem();
		this.status = obj.getStatus();
		this.quantidade = obj.getQuantidade();
		this.preco = obj.getPreco();
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

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
	
	

}
