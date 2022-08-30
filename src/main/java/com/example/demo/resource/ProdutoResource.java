package com.example.demo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Produto;
import com.example.demo.domain.dto.ProdutoDTO;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos" )
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> finbAll(){
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO objDTO){
		Produto newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Integer id,@Valid @RequestBody ProdutoDTO objDTO ){
		Produto obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProdutoDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
