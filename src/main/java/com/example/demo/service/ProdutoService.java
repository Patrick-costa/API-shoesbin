package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Produto;
import com.example.demo.domain.dto.ProdutoDTO;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.exceptions.ObjectnotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findById(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Produto create(ProdutoDTO objDTO) {
		Produto newObj = new Produto(objDTO);
		return produtoRepository.save(newObj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Produto update(Integer id, @Valid ProdutoDTO objDTO) {
			objDTO.setId(id);
			Produto oldObj = findById(id);
			oldObj = new Produto(objDTO);
			return produtoRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}

}
