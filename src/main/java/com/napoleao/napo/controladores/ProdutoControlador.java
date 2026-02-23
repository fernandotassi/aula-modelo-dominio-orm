package com.napoleao.napo.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
	public ProdutoDTO encontraPelo(@PathVariable Long id)
	{
	   return prodserv.encontraPeloId(id);	   
	  
	}
}
