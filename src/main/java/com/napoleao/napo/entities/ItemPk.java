package com.napoleao.napo.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ItemPk 
{
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	public ItemPk(){}	
	
	public void setPedido(Pedido pedido){this.pedido = pedido;}
	public void setProduto(Produto produto){this.produto = produto;}

	public Pedido getPedido(){return pedido;}
	public Produto getProduto(){return produto;}	
}
