package com.napoleao.napo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.napoleao.napo.dto.CategoriaDTO;
import com.napoleao.napo.entities.Categoria;
import com.napoleao.napo.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico
{
	@Autowired
	private CategoriaRepositorio catRepo;
	
	@Transactional(readOnly = true)
	public CategoriaDTO encontraPeloId(Long id)
	{
		Optional<Categoria> res = catRepo.findById(id);
		Categoria cat = res.get();
		CategoriaDTO dto = new CategoriaDTO(cat);
		return dto;
 	}
	
	@Transactional
	public Page<CategoriaDTO> encontraTodos(Pageable pageable)
	{
	    Page<Categoria> cat = catRepo.findAll(pageable);
		return cat.map(x -> new CategoriaDTO(x)); 
	}
}
