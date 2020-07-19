package com.produtos.apirest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.model.Produtos;
import com.produtos.apirest.repository.ProdutosRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutosController {

	@Autowired
	ProdutosRepository produtosRepository;
	
	@GetMapping("/produtos")
	public List<Produtos> produtos(String nome) {
		List<Produtos> produtos = new ArrayList<Produtos>();
		if (nome == null) {
			produtos = produtosRepository.findAll();
			return produtos;			
		} else {
			produtos = produtosRepository.findByNome(nome);
			return produtos;
		}
	}
	
	@GetMapping("/produtos/{id}")
	public Produtos listaProdutoUnico(@PathVariable(value = "id") long id) {
		Produtos produto = produtosRepository.findById(id);
		return produto;
	}
	
	@PostMapping("/produtos")
	public Produtos salvaProduto(@RequestBody Produtos produto) {
		return produtosRepository.save(produto);
	}
	
	@PutMapping("/produtos")
	public void atualizaProduto(@RequestBody Produtos produto) {
		produtosRepository.save(produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public void deletaProduto(@PathVariable long id) {
		produtosRepository.deleteById(id);
	}
}
