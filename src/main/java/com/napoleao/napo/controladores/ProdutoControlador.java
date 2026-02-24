package com.napoleao.napo.controladores;

import java.lang.System.Logger;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.napoleao.napo.dto.ProdutoDTO;
import com.napoleao.napo.entities.Produto;
import com.napoleao.napo.repositorios.ProdutoRepositorio;
import com.napoleao.napo.services.ProdutoServico;

@RestController
@RequestMapping(value = "/produtoses")
public class ProdutoControlador
{
	@Autowired
	private ProdutoServico prodserv;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> encontraPelo(@PathVariable Long id)
	{
	   ProdutoDTO dto = prodserv.encontraPeloId(id);
	   return ResponseEntity.ok(dto);   	  
	}
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> encontraTodos(Pageable pageable)
	{
		Page<ProdutoDTO> dto =  prodserv.encontraTodos(pageable);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> inserir(@RequestBody ProdutoDTO dto)
	{
		ProdutoDTO res = prodserv.inserir(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(res.getId()).toUri();
		return ResponseEntity.created(uri).body(res);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutoDTO> atualiza(@PathVariable Long id, @RequestBody ProdutoDTO dto)
	{
		dto = prodserv.atualizar(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id)
	{
		prodserv.deletar(id);
    	return ResponseEntity.noContent().build();
	}
}
