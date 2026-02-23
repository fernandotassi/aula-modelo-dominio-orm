package com.napoleao.napo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@GetMapping
	public Page<CategoriaDTO> encontraTodos(Pageable pageable)
	{return catserv.encontraTodos(pageable);}
}
