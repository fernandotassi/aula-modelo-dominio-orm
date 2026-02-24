package com.napoleao.napo.dto;

import org.apache.catalina.startup.Catalina;

import com.napoleao.napo.entities.Categoria;

public class CategoriaDTO
{
	private Long id;
	private String nome;
	
	public CategoriaDTO(){}

	public CategoriaDTO(Long id, String nome) 
	{this.id = id; this.nome = nome;}
	
	public CategoriaDTO(Categoria cat){id = cat.getId(); nome = cat.getNome();}

	public Long getId(){return id;}
	public String getNome(){return nome;}
}
