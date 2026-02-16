package com.napoleao.napo.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
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
	
	@OneToMany(mappedBy = "id.produto")
	private Set<Item> pegaPedido = new HashSet<>();
	
	public Produto(){}
	public Produto(Long id, String nome, String descricao, Double preco, String imgUri)
	{this.id = id; this.nome = nome; this.descricao = descricao; this.preco = preco; this.imgUri = imgUri;}
		
	public void setId(Long id){this.id = id;}
	public void setNome(String nome){this.nome = nome;}	
	public void setDescricao(String descricao){this.descricao = descricao;}
	public void setPreco(Double preco){this.preco = preco;}	
	public void setImgUri(String imgUri){this.imgUri = imgUri;}	

	public Long getId(){return id;}
	public String getNome(){return nome;}
	public String getDescricao(){return descricao;}
	public Double getPreco(){return preco;}
	public String getImgUri(){return imgUri;}
	public Set<Categoria> getCategorias(){return categorias;}
	public Set<Item> getPedido(){return pegaPedido;}
	
	public List<Pedido> buscaPedido()
	{return pegaPedido.stream().map(x -> x.getPedido()).toList();}
}
