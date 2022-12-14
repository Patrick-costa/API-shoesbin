package com.example.demo.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.Pessoa;
import com.example.demo.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected Integer id;
	
	@NotNull(message = "O Campo NOME é requerido")
	protected String nome;
	@NotNull(message = "O Campo CPF é requerido")
	protected String cpf;
	@NotNull(message = "O Campo EMAIL é requerido")
	protected String email;
	@NotNull(message = "O Campo SENHA é requerido")
	protected String senha;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	protected List<Endereco> endereco = new ArrayList<>();
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@NotNull(message = "O Campo TELEFONE é requerido")
	private String telefone;
	
	private String imagemUrl;
	
	public PessoaDTO() {
		super();
		addPerfil(Perfil.CLIENTE);
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.endereco = obj.getEndereco();
		this.data = obj.getData();
		this.imagemUrl = obj.getImagemUrl();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	
	
	
	
}
