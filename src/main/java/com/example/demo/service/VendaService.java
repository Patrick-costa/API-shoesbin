package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	@Autowired
	private UserDetailsServiceImpl userDet;
	
	public Venda findById(Integer id) {
		Optional<Venda> obj = vendaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Venda> findAll() {
		List<Venda> venda = vendaRepository.findAll();
		return venda.stream().filter((x) -> x.getClienteId().equals(userDet.getIdUser())).collect(Collectors.toList());
	}
	
	public Venda create(VendaDTO objDTO) {
		Venda newObj = new Venda(objDTO);
		newObj.setClienteId(userDet.getIdUser());
		return vendaRepository.save(newObj);
	}
	
	
}
