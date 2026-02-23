package com.napoleao.napo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.napoleao.napo.dto.ProdutoDTO;
import com.napoleao.napo.entities.Produto;
import com.napoleao.napo.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico 
{
	@Autowired
	private ProdutoRepositorio prodrepo;
	
	@Transactional(readOnly = true)
	public ProdutoDTO encontraPeloId(Long id)
	{
		Optional<Produto> res = prodrepo.findById(id);
		Produto prod = res.get();
		ProdutoDTO dto = new ProdutoDTO(prod);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public Page<ProdutoDTO> encontraTodos(Pageable pageable)
	{
		Page<Produto> produtos = prodrepo.findAll(pageable);
		return produtos.map(x -> new ProdutoDTO(x));
	}
}
