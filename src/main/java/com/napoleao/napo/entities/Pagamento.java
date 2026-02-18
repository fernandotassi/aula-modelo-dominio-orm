package com.napoleao.napo.entities;

import java.time.Instant;
import java.util.Objects;

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
	
	
	public void setId(Long id){this.id = id;}
	public void setMomento(Instant momento){this.momento = momento;}
	public void setPedido(Pedido pedido){this.pedido = pedido;}
	
	public Long getId(){return id;}
	public Instant getMomento(){return momento;}
	public Pedido getPedido(){return pedido;}
	
	@Override
	public int hashCode(){return Objects.hash(id);}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}	
}
