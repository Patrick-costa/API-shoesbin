package com.example.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Pessoa;
import com.example.demo.domain.dto.PessoaDTO;
import com.example.demo.service.PessoaService;
import com.example.demo.service.UserDetailsServiceImpl;

@RestController
@RequestMapping(value = "/usuarios")

public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@Autowired
	private UserDetailsServiceImpl userDet;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id){
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<Pessoa> list = service.findAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/meuUsuario")
	public ResponseEntity<List<PessoaDTO>> findUser(){
		List<Pessoa> list = service.findAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		listDTO = listDTO.stream().filter(obj -> obj.getId().equals(userDet.getIdUser())).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO objDTO){
		Pessoa newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{îd}").buildAndExpand(newObj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
}
