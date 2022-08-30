package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Pessoa;
import com.example.demo.enums.Perfil;
import com.example.demo.repository.PessoaRepository;


@SpringBootApplication
public class ShoesbinApplication  implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(ShoesbinApplication.class, args);
	}
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Pessoa obj = new Pessoa(null,"Patrick","10297397737","patrick@gmail.com","1234");
		obj.addPerfil(Perfil.ADMIN);
		obj.addPerfil(Perfil.CLIENTE);
		pessoaRepository.saveAll(Arrays.asList(obj));
	}
}
