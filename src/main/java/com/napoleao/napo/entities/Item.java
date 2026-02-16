package com.napoleao.napo.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
public class Item
{
	@EmbeddedId 
	private ItemPk id = new ItemPk();
	private Integer quantidade;
	private Double preco;
	
	public Item(){}
	public Item(Pedido pedido, Produto produto, Integer quantidade, Double preco)
	{id.setPedido(pedido); id.setProduto(produto);  this.quantidade = quantidade; this.preco = preco;}
	
	public Pedido getPedido(){return id.getPedido();}
	public Produto getProduto(){return id.getProduto();}
	public Integer getQuantidade(){return quantidade;}
	public Double getPreco(){return preco;}
	
	public void setPedido(Pedido pedido){id.setPedido(pedido);}
	public void setProduto(Produto produto){id.setProduto(produto);}
	public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}
	public void setPreco(Double preco){this.preco = preco;}	
}
