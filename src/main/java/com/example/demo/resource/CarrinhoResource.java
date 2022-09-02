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

import com.example.demo.domain.Carrinho;
import com.example.demo.domain.dto.CarrinhoDTO;
import com.example.demo.service.CarrinhoService;

@RestController
@RequestMapping(value = "/carrinho")
public class CarrinhoResource {
	
	@Autowired
	private CarrinhoService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CarrinhoDTO> findById(@PathVariable Integer id){
		Carrinho obj = service.findById(id);
		return ResponseEntity.ok().body(new CarrinhoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CarrinhoDTO>> findAll(){
		List<Carrinho> list = service.findAll();
		List<CarrinhoDTO> listDTO = list.stream().map(obj -> new CarrinhoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<CarrinhoDTO> create(@Valid @RequestBody CarrinhoDTO objDTO){
		Carrinho newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CarrinhoDTO> update(@PathVariable Integer id, @Valid @RequestBody CarrinhoDTO objDTO){
		Carrinho obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new CarrinhoDTO(obj));
		}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CarrinhoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
