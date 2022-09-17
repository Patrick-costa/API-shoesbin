package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Favoritos;
import com.example.demo.domain.dto.FavoritosDTO;
import com.example.demo.repository.FavoritosRepository;
import com.example.demo.service.exceptions.ObjectnotFoundException;

@Service
public class FavoritosService {
	
	@Autowired
	FavoritosRepository repository;
	
	@Autowired
	private UserDetailsServiceImpl userDet;
	
	public Favoritos findById(Integer id) {
		Optional<Favoritos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: "+ id ));
	}
	
	public List<Favoritos> findAll() {
		List<Favoritos> list = repository.findAll();
		return list.stream().filter((x) -> x.getIdUsuario().equals(userDet.getIdUser())).collect(Collectors.toList());
	}
	
	public Favoritos create(FavoritosDTO objDTO) {
		Favoritos newObj = new Favoritos(objDTO);
		newObj.setIdUsuario(userDet.getIdUser());
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
