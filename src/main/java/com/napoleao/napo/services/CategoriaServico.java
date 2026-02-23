package com.napoleao.napo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.napoleao.napo.dto.CategoriaDTO;
import com.napoleao.napo.entities.Categoria;
import com.napoleao.napo.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico
{
	@Autowired
	private CategoriaRepositorio catRepo;
	
	public CategoriaDTO encontraPeloId(Long id)
	{
		Optional<Categoria> res = catRepo.findById(id);
		Categoria cat = res.get();
		CategoriaDTO dto = new CategoriaDTO(cat);
		return dto;
 	}
}
