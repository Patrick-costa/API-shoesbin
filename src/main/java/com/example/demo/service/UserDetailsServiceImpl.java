package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.security.UseSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private PessoaRepository repository;

	public Integer idUser;
	private Integer teste;
	
	public UserDetailsServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	

	public UserDetailsServiceImpl(Integer idUser) {
		super();
		this.idUser = this.teste;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByEmail(email);
		setIdUser(user.get().getId());
		if(user.isPresent()) {
			return new UseSS(user.get().getId(), user.get().getEmail(), user.get().getSenha(), user.get().getPerfis());
		}
		throw new UsernameNotFoundException(email);
	}


}
