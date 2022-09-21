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

import com.example.demo.domain.Venda;
import com.example.demo.domain.dto.VendaDTO;
import com.example.demo.service.VendaService;

@RestController
@RequestMapping(value = "/venda" )
public class VendaResource {

	@Autowired
	private VendaService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Integer id){
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(new VendaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll(){
		List<Venda> list = service.findAll();
		List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<VendaDTO> create(@Valid @RequestBody VendaDTO objDTO){
		Venda newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

}
