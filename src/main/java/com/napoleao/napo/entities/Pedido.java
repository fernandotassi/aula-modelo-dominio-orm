package com.napoleao.napo.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pedido")
public class Pedido 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "timestamp without time zone")
	private Instant momento;
	private StatusPedido estado;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Usuario cliente;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) 
	private Pagamento pagamento;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<Item> pegaProduto = new HashSet<>(); 
	
	public Pedido(){}
	public Pedido(Long id, Instant momento, StatusPedido estado, Usuario cliente, Pagamento pagamento)
	{this.id = id; this.momento = momento; this.estado = estado; this.cliente = cliente; 
	 this.pagamento = pagamento;}
	
	public void setId(Long id){	this.id = id;}	
	public void setMomento(Instant momento){this.momento = momento;}	
	public void setEstado(StatusPedido status){this.estado = estado;}	
	public void setCliente(Usuario cliente){this.cliente = cliente;}
	public void setPagamento(Pagamento pagamento){this.pagamento = pagamento;}
	
	public Long getId(){return id;}
	public Instant getMomento(){return momento;}
	public StatusPedido getEstado(){return estado;}
	public Usuario getCliente(){return cliente;}
	public Pagamento getPagamento(){return pagamento;}
	public Set<Item> getPegaProduto(){return pegaProduto;}
	
	public List<Produto> buscaProduto()
	{return pegaProduto.stream().map(x -> x.getProduto()).toList();}
	
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
