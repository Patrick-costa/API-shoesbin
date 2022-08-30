package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Venda;
import com.example.demo.domain.dto.VendaDTO;
import com.example.demo.repository.VendaRepository;
import com.example.demo.service.exceptions.ObjectnotFoundException;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;
	
	public Venda findById(Integer id) {
		Optional<Venda> obj = vendaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	public Venda create(VendaDTO objDTO) {
		Venda newObj = new Venda(objDTO);
		return vendaRepository.save(newObj);
	}
	
	
}
