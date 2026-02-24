package com.napoleao.napo.dto;

import com.napoleao.napo.entities.Produto;

public class ProdutoDTO 
{
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
		
	public ProdutoDTO(Long id, String nome, String descricao, Double preco, String imgUrl) 
	{this.id = id; this.nome = nome; this.descricao = descricao; this.preco = preco; this.imgUrl = imgUrl;}
	
	public ProdutoDTO(Produto prod)
	{id = prod.getId(); nome = prod.getNome(); descricao = prod.getDescricao(); preco = prod.getPreco();
	 imgUrl = prod.getImgUrl();}
	
	public Long getId(){return id;}
	public String getNome(){return nome;}
	public String getDescricao(){return descricao;}
	public Double getPreco(){return preco;}
	public String getImgUrl(){return imgUrl;}		
}	
	
