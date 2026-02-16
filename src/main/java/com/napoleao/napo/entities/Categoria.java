package com.napoleao.napo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categoria")
public class Categoria 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToMany(mappedBy = "categorias")
	@Setter(AccessLevel.NONE)
	private Set<Produto> produtos = new HashSet<>(); 
	
	public Categoria(){}
	public Categoria(Long id, String nome)
	{this.id = id; this.nome = nome;}
	
	public void setId(Long id){this.id = id;}
	public void setNome(String nome){this.nome = nome;}
	public Long getId(){return id;}
	public String getNome(){return nome;}
	public Set<Produto> getProdutos(){return produtos;}	
}
