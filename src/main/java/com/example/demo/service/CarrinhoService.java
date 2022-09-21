package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Carrinho;
import com.example.demo.domain.dto.CarrinhoDTO;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.service.exceptions.ObjectnotFoundException;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private UserDetailsServiceImpl userDet;
	
	
	public Carrinho findById(Integer id) {
		Optional<Carrinho> obj = carrinhoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Carrinho> findAll(){
		List<Carrinho> carrinho = carrinhoRepository.findAll();
		return carrinho.stream().filter((x) -> x.getClienteId().equals(userDet.getIdUser())).collect(Collectors.toList());
	}
	
	public Carrinho create(CarrinhoDTO objDTO) {
		Carrinho newObj = new Carrinho(objDTO);
		newObj.setClienteId(userDet.getIdUser());
		return carrinhoRepository.save(newObj);
	}
	
	public Carrinho update(Integer id, @Valid CarrinhoDTO objDTO) {
		objDTO.setId(id);
		Carrinho oldObj = findById(id);
		
		oldObj = new Carrinho(objDTO);
		return carrinhoRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		carrinhoRepository.deleteById(id);
	}
	
	

}
