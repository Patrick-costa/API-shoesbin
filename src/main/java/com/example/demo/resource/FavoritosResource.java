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

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Favoritos;
import com.example.demo.domain.dto.FavoritosDTO;
import com.example.demo.service.FavoritosService;

@RestController
@RequestMapping(value="/favoritos")
public class FavoritosResource {
	
	@Autowired
	private FavoritosService service;
	
	@GetMapping
	public ResponseEntity<List<FavoritosDTO>> findAll(){
		List<Favoritos> list = service.findAll();
		List<FavoritosDTO> listDTO = list.stream().map(obj -> new FavoritosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<FavoritosDTO> findById(@PathVariable Integer id){
		Favoritos obj = service.findById(id);
		return ResponseEntity.ok().body(new FavoritosDTO(obj));
	}
	
	@GetMapping(value="/produto/{id}")
	public ResponseEntity<List<FavoritosDTO>> findByProdutoId(@PathVariable Integer id){
		List<Favoritos> obj = service.findByIdProduto(id);
		List<FavoritosDTO> listDTO = obj.stream().map(x -> new FavoritosDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<FavoritosDTO> create(@Valid @RequestBody FavoritosDTO objDTO){
		Favoritos newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{îd}").buildAndExpand(newObj.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FavoritosDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
