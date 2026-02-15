package com.napoleao.napo.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@ToString
public class Pagamento 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "timestamp without time zone")
	private Instant momento;
	
	@OneToOne
	@MapsId
	private Pedido pedido;
	
	public Pagamento(){}
	public Pagamento(Long id, Instant momento, Pedido pedido)
	{this.id = id; this.momento = momento; this.pedido = pedido;}
}
