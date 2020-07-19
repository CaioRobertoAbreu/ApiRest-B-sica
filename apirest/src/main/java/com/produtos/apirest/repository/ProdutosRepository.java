package com.produtos.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	List<Produtos> findByNome(String nome);
	
	Produtos findById(long id);	
}
