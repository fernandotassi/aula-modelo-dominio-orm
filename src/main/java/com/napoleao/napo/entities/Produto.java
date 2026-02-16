package com.napoleao.napo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Getter
@Setter
@ToString
public class Produto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(columnDefinition = "text")
	private String descricao;
	private Double preco;
	private String imgUri;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria", joinColumns = @JoinColumn(name = "id_produto"),
	           inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	@Setter(AccessLevel.NONE)
	private Set<Categoria> categorias = new HashSet<>();
	
	public Produto(){}
	public Produto(Long id, String nome, String descricao, Double preco, String imgUri)
	{this.id = id; this.nome = nome; this.descricao = descricao; this.preco = preco; this.imgUri = imgUri;}
}
