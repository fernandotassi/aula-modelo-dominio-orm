package com.napoleao.napo.dto;

import com.napoleao.napo.entities.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProdutoDTO 
{
	private Long id;
	@Size(min = 3, max = 80, message = "3 a 80 caracteres")
	@NotBlank(message = "campo obrigatório")
	private String nome;
	@Size(min = 10, message = "minímo 10 caracteres")
	@NotBlank(message = "campo obrigatório")
	private String descricao;
	@Positive(message = "preço é positivo")
	private Double preco;
	private String imgUrl;
	
	public ProdutoDTO(){}
	
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
	
