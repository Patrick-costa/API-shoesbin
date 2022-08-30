package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.domain.dto.PessoaDTO;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.exceptions.ObjectnotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa create(PessoaDTO objDTO) {
		Pessoa newObj = new Pessoa(objDTO);
		return pessoaRepository.save(newObj);
	}
	
}
