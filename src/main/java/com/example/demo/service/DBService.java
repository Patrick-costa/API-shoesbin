package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.enums.Perfil;
import com.example.demo.repository.PessoaRepository;


@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	public void instanciaDB() {
		Pessoa obj = new Pessoa(null,"Patrick","10297397737","patrick@gmail.com","1234");
		obj.addPerfil(Perfil.ADMIN);
		
		pessoaRepository.saveAll(Arrays.asList(obj));
		
	}
}
