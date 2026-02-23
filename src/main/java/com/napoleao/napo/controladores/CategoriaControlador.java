package com.napoleao.napo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napoleao.napo.dto.CategoriaDTO;
import com.napoleao.napo.services.CategoriaServico;

@RestController
@RequestMapping(value = "/categoriases")
public class CategoriaControlador 
{
	@Autowired
	private CategoriaServico catserv;
    
	@GetMapping(value = "/{id}")
	public CategoriaDTO encontraPeloId(@PathVariable Long id)
	{ return catserv.encontraPeloId(id);}
}
