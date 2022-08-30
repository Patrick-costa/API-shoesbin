package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer> {

}
