package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cor;
	private Integer tamanho;
	private Integer quantidade;
	private String imagem;
	
	public Estoque(Integer id, String cor, Integer tamanho, Integer quantidade, String imagem) {
		super();
		this.id = id;
		this.cor = cor;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.imagem = "https://shoesbin.s3.sa-east-1.amazonaws.com/" + imagem;
	}

	public Estoque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = "https://shoesbin.s3.sa-east-1.amazonaws.com/" + imagem;
	}
	
	
	
	
	
}
