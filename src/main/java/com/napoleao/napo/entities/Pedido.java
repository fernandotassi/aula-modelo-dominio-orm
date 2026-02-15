package com.napoleao.napo.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@ToString
public class Pedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "timestamp without time zone")
	private Instant momento;
	private StatusPedido status;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Usuario cliente;
	//private Pagamento pagamento = 
	
	public Pedido(){}
	public Pedido(Long id, Instant momento, StatusPedido status)
	{this.id = id; this.momento = momento; this.status = status;}
}
